package com.cbf.data_exchange.config_enum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public enum OracleNullSetEnum {
    ;
    private String columnType;
    private int nullType;
    OracleNullSetEnum(String columnType, int nullType){
        this.columnType = columnType;
        this.nullType = nullType;
    }
    Map<String,Map<String, Integer>> columnTypeSetNullTypeMap = new HashMap<>();;
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        OracleNullSetEnum[] typeEnums = OracleNullSetEnum.values();
        for(OracleNullSetEnum typeEnum: typeEnums){

        }
    }
    public int getNullType(String dbType, String columnType){
        return 0;
    }
}
