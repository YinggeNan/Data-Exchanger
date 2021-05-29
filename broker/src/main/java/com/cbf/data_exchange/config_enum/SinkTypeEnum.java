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

    /**
     * {sinkTypeEnumString:SinkTypeEnum}
     */
    public static Map<String, SinkTypeEnum> map = new HashMap<>();
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        SinkTypeEnum[] typeEnums = SinkTypeEnum.values();
        for(SinkTypeEnum typeEnum: typeEnums){
            map.put(typeEnum.getName(), typeEnum);
        }
    }
    public static SinkTypeEnum getEnum(String name){
        return map.get(name);
    }
}
