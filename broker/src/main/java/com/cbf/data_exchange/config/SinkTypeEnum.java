package com.cbf.data_exchange.config;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum SinkTypeEnum {
    DB_SINKER("DB"),
    KAFKA_SINKER("KAFKA"),
    FILE_SINKER("FILE");
    SinkTypeEnum(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }
    public SinkTypeEnum getByName(String sinkTypeEnum){
        for(SinkTypeEnum typeName: SinkTypeEnum.values()){
            if(StringUtils.equals(name, typeName.getName())){
                return typeName;
            }
        }
        return null;
    }
}
