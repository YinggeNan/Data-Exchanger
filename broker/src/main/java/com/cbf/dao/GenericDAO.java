package com.cbf.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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
    public Integer batchUpdate(){
        return null;
    }
}
