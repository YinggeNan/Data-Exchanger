package com.cbf.data_exchange.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class DBUtilTest {
    @Test
    public void constructInsertSqlForOracleTest(){
        Assert.assertEquals("INSERT INTO cbf_test (name,age,height,profit,school,reason) VALUES (?,?,?,?,?,?) ",
                DBUtil.constructInsertSqlForOracle("cbf_test",
                        new String[]{"name", "age", "height", "profit", "school", "reason"}));
    }
    @Test
    public void constructInsertSqlForMysqlTest(){
        System.out.println(DBUtil.constructInsertSqlForMysql("sink_test_dataexchanger",
                new String[]{"cobdate", "country", "province", "city", "carNumber", "profit"}));
        Assert.assertEquals("INSERT INTO sink_test_dataexchanger (cobdate,country,province,city,carNumber,profit) VALUES (?,?,?,?,?,?) ",
                DBUtil.constructInsertSqlForMysql("sink_test_dataexchanger",
                        new String[]{"cobdate", "country", "province", "city", "carNumber", "profit"}));
    }
    @Test
    public void buildJdbcTemplateTestForMysql(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?"+"serverTimezone=GMT";
        JdbcTemplate jdbcTemplate = DBUtil.buildJdbcTemplate(driverClass, userName, ps, url);
        String sql = "select * from sink_test_dataexchanger";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
    }
    @Test
    public void buildJdbcTemplateTestForOracle(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/";

    }
    @Test
    public void buildJdbcTemplateTestForSqlserver(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/";

    }
}
