package com.cbf.data_exchange.config_enum;

import java.sql.Blob;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description:
 */
public enum JavaDataTypeEnum {
    BYTE("byte"),
    SHORT("short"),
    INT("int"),
    LONG("long"),
    FLOAT("float"),
    DOUBLE("double"),
    BOOLEAN("boolean"),
    CHAR("char"),
    STRING("String"),
    BIGDECIMAL("BigDecimal"),
    TIMESTAMP("Timestamp")
    ;
    private String dataType;
    public String getDataType() {
        return dataType;
    }
    JavaDataTypeEnum(String dataType){
        this.dataType = dataType;
    }
    private static Map<String, JavaDataTypeEnum> map;
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        JavaDataTypeEnum[] typeEnums = JavaDataTypeEnum.values();
        for(JavaDataTypeEnum typeEnum: typeEnums){
            map.put(typeEnum.getDataType(), typeEnum);
        }
    }
    public JavaDataTypeEnum getEnum(String dataType){
        return map.get(dataType);
    }
}
