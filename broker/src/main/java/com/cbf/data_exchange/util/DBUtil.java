package com.cbf.data_exchange.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
@Slf4j
public class DBUtil {
    public static JdbcTemplate buildJdbcTemplate(String driverClass, String userName,
                                                 String ps, String url){
        {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(ps);
            return new JdbcTemplate(dataSource);
        }
    }
    public static JdbcTemplateBuilder getJdbcTemplateBuilder(){
        return new JdbcTemplateBuilder();
    }
    public static class JdbcTemplateBuilder{
        private String driverClass;
        private String userName;
        private String ps;
        private String url;

        public JdbcTemplateBuilder setDriverClass(String driverClass) {
            this.driverClass = driverClass;
            return this;
        }

        public JdbcTemplateBuilder setPs(String ps) {
            this.ps = ps;
            return this;
        }

        public JdbcTemplateBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public JdbcTemplateBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }
        public JdbcTemplate buildJdbcTemplate(){
            if(StringUtils.isEmpty(driverClass)){
                log.error("driverClass can't be empty");
                throw new RuntimeException("driverClass can't be empty");
            }
            if(StringUtils.isEmpty(userName)){
                log.error("userName can't be empty");
                throw new RuntimeException("userName can't be empty");
            }
            if(StringUtils.isEmpty(ps)){
                log.error("ps can't be empty");
                throw new RuntimeException("ps can't be empty");
            }
            if(StringUtils.isEmpty(url)){
                log.error("url can't be empty");
                throw new RuntimeException("url can't be empty");
            }
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(ps);
            return new JdbcTemplate(dataSource);
        }

    }
    public static String constructInsertSqlForOracle(String dbName, String[] sinkSequence){
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO "+dbName+" ");
        builder.append("(");
        for(String columnName: sinkSequence){
            builder.append(columnName);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(") ");
        builder.append("VALUES (");
        for(int i = 0;i < sinkSequence.length;i++){
            builder.append("?,");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(") ");
        return builder.toString();
    }
    public static String constructInsertSqlForMysql(String dbName, String[] sinkSequence){
        return constructInsertSqlForOracle(dbName, sinkSequence);
    }
}
