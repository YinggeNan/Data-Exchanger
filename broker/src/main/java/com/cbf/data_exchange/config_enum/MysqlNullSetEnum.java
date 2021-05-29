package com.cbf.data_exchange.config_enum;

import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public enum MysqlNullSetEnum {

    ;
    private MysqlDataTypeEnum columnType;
    private int nullType;
    MysqlNullSetEnum(MysqlDataTypeEnum columnType, int nullType){
        this.columnType = columnType;
        this.nullType = nullType;
    }
    Map<String,Map<String, Integer>> columnTypeSetNullTypeMap;
    static {
        constructTypeMap();
    }
    private static void constructTypeMap(){
        MysqlNullSetEnum[] typeEnums = MysqlNullSetEnum.values();
        for(MysqlNullSetEnum typeEnum: typeEnums){

        }
    }
    public int getNullType(String dbType, String columnType){
        return 0;
    }
}
