package com.cbf.config;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum SinkTypeEnum {
    DBSinker("DB"),
    KafkaSinker("kafka");
    SinkTypeEnum(String name){
        this.name = name;
    }
    private String name;
}
