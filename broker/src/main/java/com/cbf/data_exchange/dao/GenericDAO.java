package com.cbf.data_exchange.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class GenericDAO {
    JdbcTemplate jdbcTemplate;
    public GenericDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * @param sql
     * @param batchNumber
     * @param data
     * @param sinkSequence sql中的column从左到右的顺序
     * @param columnType sql中每个column的对应类型
     * @return
     */
    @Transactional
    public Integer batchUpdate(String sql,int batchNumber, List<Map<String, Object>> data,
                               String[] sinkSequence, Map<String, String> columnType){
        int[] ans = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            /**
             * i指的是传入的列表中的第i个元素
             * 参考: https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch12s04.html
             * @param ps
             * @param i
             * @throws SQLException
             */
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> item = data.get(i);
                for(int j=0;j<sinkSequence.length;j++){
                    String columnName = sinkSequence[j];
                    if(item.get(columnName)!=null){
                        ps.setObject(j, item.get(columnName));
                    }else{
                        ps.setNull(j, Types.BIGINT);
                    }
                }
            }

            @Override
            public int getBatchSize() {
                return batchNumber;
            }
        });
        return null;
    }
    public List<Map<String, Object>> queryForList(String sql){
        return jdbcTemplate.queryForList(sql);
    }
    public Map<String, String> getColumnTypeMapForMysql(String dbName){
        String sql = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS \n" +
                "  WHERE table_name = '"+ dbName+ "' ";
        List<Map<String, Object>> list = queryForList(sql);
        Map<String, String> dataTypeMap = new HashMap<>();
        for(Map<String, Object> map: list){
            // COLUMN_NAME, DATA_TYPE
            String columnName = (String) map.get("COLUMN_NAME");
            String columnType = (String) map.get("DATA_TYPE");
            dataTypeMap.put(columnName, columnType);
        }
        return dataTypeMap;
    }
}
