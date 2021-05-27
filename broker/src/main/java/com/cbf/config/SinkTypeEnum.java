package com.cbf.config;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum SinkTypeEnum {
    DB_SINKER("DB"),
    KAFKA_SINKER("kafka"),
    FILE_SINKER("file");
    SinkTypeEnum(String name){
        this.name = name;
    }
    private String name;
}
