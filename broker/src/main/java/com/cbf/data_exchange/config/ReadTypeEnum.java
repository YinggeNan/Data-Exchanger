package com.cbf.data_exchange.config;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum ReadTypeEnum {
    DB_SINKER("DB"),
    KAFKA_SINKER("kafka"),
    FILE_SINKER("file");
    ReadTypeEnum(String name){
        this.name = name;
    }
    private String name;
}
