package com.cbf.data_exchange.config_enum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 * 参考: http://www.java2s.com/Tutorial/Java/0340__Database/MySQLDatatypetoJavaDatatypeConversionTable.htm
 */
public enum MysqlJavaDataConvertEnum {
    /**
     * this series of mysql type all convert into java "java.lang.String"
     */
    CHAR(MysqlDataTypeEnum.CHAR, JavaDataTypeEnum.STRING),
    VARCHAR(MysqlDataTypeEnum.VARCHAR, JavaDataTypeEnum.STRING),
    BLOB(MysqlDataTypeEnum.BLOB, JavaDataTypeEnum.STRING),
    TEXT(MysqlDataTypeEnum.TEXT, JavaDataTypeEnum.STRING),
    ENUM(MysqlDataTypeEnum.ENUM, JavaDataTypeEnum.STRING),
    SET(MysqlDataTypeEnum.SET, JavaDataTypeEnum.STRING),

    /**
     * this series of mysql type all convert into java "java.math.BigDecimal"
     */
    FLOAT(MysqlDataTypeEnum.FLOAT, JavaDataTypeEnum.BIGDECIMAL),
    REAL(MysqlDataTypeEnum.REAL, JavaDataTypeEnum.BIGDECIMAL),
    DOUBLE(MysqlDataTypeEnum.DOUBLE, JavaDataTypeEnum.BIGDECIMAL),
    NUMERIC(MysqlDataTypeEnum.NUMERIC, JavaDataTypeEnum.BIGDECIMAL),
    DECIMAL(MysqlDataTypeEnum.DECIMAL, JavaDataTypeEnum.BIGDECIMAL),
    TINYINT(MysqlDataTypeEnum.TINYINT, JavaDataTypeEnum.BIGDECIMAL),
    SMALLINT(MysqlDataTypeEnum.SMALLINT, JavaDataTypeEnum.BIGDECIMAL),
    MEDIUMINT(MysqlDataTypeEnum.MEDIUMINT, JavaDataTypeEnum.BIGDECIMAL),
    INTEGER(MysqlDataTypeEnum.INTEGER, JavaDataTypeEnum.BIGDECIMAL),
    BIGINT(MysqlDataTypeEnum.BIGINT, JavaDataTypeEnum.BIGDECIMAL),

    /**
     * this series of mysql type all convert into java "java.sql.Timestamp"
     */
    DATE(MysqlDataTypeEnum.DATE, JavaDataTypeEnum.TIMESTAMP),
    TIME(MysqlDataTypeEnum.TIME, JavaDataTypeEnum.TIMESTAMP),
    DATETIME(MysqlDataTypeEnum.DATETIME, JavaDataTypeEnum.TIMESTAMP),
    TIMESTAMP(MysqlDataTypeEnum.TIMESTAMP, JavaDataTypeEnum.TIMESTAMP),
    ;




    private MysqlDataTypeEnum mysqlDataTypeEnum;
    private JavaDataTypeEnum javaDataTypeEnum;
    MysqlJavaDataConvertEnum(MysqlDataTypeEnum mysqlDataTypeEnum,
                             JavaDataTypeEnum javaDataTypeEnum){
        this.mysqlDataTypeEnum = mysqlDataTypeEnum;
        this.javaDataTypeEnum = javaDataTypeEnum;
    }

    public JavaDataTypeEnum getJavaDataTypeEnum() {
        return javaDataTypeEnum;
    }

    public MysqlDataTypeEnum getMysqlDataTypeEnum() {
        return mysqlDataTypeEnum;
    }

    static public Map<MysqlDataTypeEnum, JavaDataTypeEnum> mysqlJavaDataConvertEnumMap = new HashMap<>();;
    static {

    }
    private static void constructConvertEnumMap(){
        MysqlJavaDataConvertEnum[] enums = MysqlJavaDataConvertEnum.values();
        for(MysqlJavaDataConvertEnum enumItem: enums){
            mysqlJavaDataConvertEnumMap.put(enumItem.mysqlDataTypeEnum,
                    enumItem.getJavaDataTypeEnum());
        }
    }
    private static JavaDataTypeEnum getMappingJavaDataTypeEnum(MysqlDataTypeEnum typeEnum){
        return mysqlJavaDataConvertEnumMap.get(typeEnum);
    }

}
