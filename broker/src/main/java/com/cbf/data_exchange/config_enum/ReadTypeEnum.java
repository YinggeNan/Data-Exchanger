package com.cbf.data_exchange.config_enum;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum ReadTypeEnum {
    DB_SINKER("DB"),
    KAFKA_SINKER("KAFKA"),
    FILE_SINKER("FILE");
    ReadTypeEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
    public ReadTypeEnum getByName(String readTypeName){
        for(ReadTypeEnum typeName: ReadTypeEnum.values()){
            if(StringUtils.equals(name, typeName.getName())){
                return typeName;
            }
        }
        return null;
    }
}
