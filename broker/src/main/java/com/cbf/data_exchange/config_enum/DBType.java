package com.cbf.data_exchange.config_enum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description:
 */
public enum DBType {
    MYSQL("mysql"),
    ORACLE("oracle"),
    SQLSERVER("sqlserver"),
    MONGODB("mongodb")
    ;
    private String dbType;
    DBType(String dbType){
        this.dbType = dbType;
    }

    public String getDbType() {
        return dbType;
    }
    public static Map<String, DBType> map = new HashMap<>();;
    private static void constructTypeMap(){
        DBType[] typeEnums = DBType.values();
        for(DBType typeEnum: typeEnums){
            map.put(typeEnum.getDbType(), typeEnum);
        }
    }
    public DBType getEnum(String dbType){
        return map.get(dbType);
    }

}
