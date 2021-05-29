package com.cbf.data_exchange.config_enum;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public enum ReadTypeEnum {
    DB_Reader("DB"),
    KAFKA_Reader("KAFKA"),
    FILE_Reader("FILE");
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
    public static Map<String, ReadTypeEnum> map = new HashMap<>();
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        ReadTypeEnum[] typeEnums = ReadTypeEnum.values();
        for(ReadTypeEnum typeEnum: typeEnums){
            map.put(typeEnum.getName(), typeEnum);
        }
    }
    public static ReadTypeEnum getEnum(String name){
        return map.get(name);
    }
}
