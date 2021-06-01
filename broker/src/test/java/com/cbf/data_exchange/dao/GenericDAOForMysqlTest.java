package com.cbf.data_exchange.dao;

import com.cbf.data_exchange.util.DBUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Locale;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class GenericDAOForMysqlTest {
    GenericDAO genericDAO;
    @Before
    public void init(){
        String dbName = "test";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?"+"serverTimezone=GMT";
        JdbcTemplate jdbcTemplate = DBUtil.buildJdbcTemplate(driverClass, userName, ps, url);
        String sql = "select * from sink_test_dataexchanger";
        genericDAO = new GenericDAO(jdbcTemplate);
    }
    @Test
    public void getColumnTypeMapForMysqlTest(){
        String dbName1 = "sink_test_dataexchanger";
        Map<String, String> dataTypeMap1 = genericDAO.getColumnTypeMapForMysql(dbName1);
        String dbName2 = "mysql_alltype_test";
        Map<String, String> dataTypeMap2 = genericDAO.getColumnTypeMapForMysql(dbName2);
        for(Map.Entry entry: dataTypeMap2.entrySet()){
            String columnType = (String) entry.getValue();
            System.out.println(columnType.toUpperCase(Locale.ROOT)+"(\""+columnType+"\"),");
        }
    }
}
