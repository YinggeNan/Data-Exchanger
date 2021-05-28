package com.cbf.data_exchange.config_enum;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

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
    /**
     * {readTypeEnumString:ReadTypeEnum}
     */
    public static Map<String, ReadTypeEnum> map;
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        ReadTypeEnum[] typeEnums = ReadTypeEnum.values();
        for(ReadTypeEnum typeEnum: typeEnums){
            map.put(typeEnum.getName(), typeEnum);
        }
    }
    public ReadTypeEnum getEnum(String name){
        return map.get(name);
    }
}
