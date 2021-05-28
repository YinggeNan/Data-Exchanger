package com.cbf.data_exchange.config;

import lombok.Data;

import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
@Data
public class DBSinkConfig {
    String sql;
    String[] sinkSequence;
    Map<String, String> columnNameAndColumnTypeMap;
}
