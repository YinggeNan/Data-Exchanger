package com.cbf.data_exchange.config_enum;

import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public enum SqlserverNullSetEnum {
    ;
    private String columnType;
    private int nullType;
    SqlserverNullSetEnum(String columnType, int nullType){
        this.columnType = columnType;
        this.nullType = nullType;
    }
    Map<String,Map<String, Integer>> columnTypeSetNullTypeMap;
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        SqlserverNullSetEnum[] typeEnums = SqlserverNullSetEnum.values();
        for(SqlserverNullSetEnum typeEnum: typeEnums){

        }
    }
    public int getNullType(String dbType, String columnType){
        return 0;
    }
}
