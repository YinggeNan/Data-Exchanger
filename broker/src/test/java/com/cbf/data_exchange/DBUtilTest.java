package com.cbf.data_exchange;

import com.cbf.data_exchange.util.DBUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class DBUtilTest {
    @Test
    void constructInsertSqlForOracleTest(){
        Assert.assertEquals("INSERT INTO cbf_test (name,age,height,profit,school,reason) VALUES (?,?,?,?,?,?) ",
                DBUtil.constructInsertSqlForOracle("cbf_test",
                        new String[]{"name", "age", "height", "profit", "school", "reason"}));
    }
    @Test
    void constructInsertSqlForMysqlTest(){
        Assert.assertEquals("INSERT INTO cbf_test (name,age,height,profit,school,reason) VALUES (?,?,?,?,?,?) ",
                DBUtil.constructInsertSqlForMysql("cbf_test",
                        new String[]{"name", "age", "height", "profit", "school", "reason"}));
    }
    @Test
    void buildJdbcTemplateTestForMysql(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/";

    }
    @Test
    void buildJdbcTemplateTestForOracle(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/";

    }
    @Test
    void buildJdbcTemplateTestForSqlserver(){
        String dbName = "test";
        String driverClass = "com.mysql.jdbc.Driver";
        String userName = "root";
        String ps = "778632ab";
        String url = "jdbc:mysql://localhost:3306/";

    }
}
