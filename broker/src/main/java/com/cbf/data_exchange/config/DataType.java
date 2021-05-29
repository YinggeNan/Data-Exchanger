package com.cbf.data_exchange.config;

import lombok.Data;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
@Data
public class DataType {
    @Data
    public static class DBType{
        private String dbType;
        private String driverClass;
        private String url;
        private String userName;
        private String password;
        private String dbName;
        private Integer batchSinkNumber;
    }
    @Data
    public static class KafkaType{
        private String topicName;
        private String schemaClass;
    }
    @Data
    public static class FileType{
        /**
         * 待读取文件路径
         */
        private String fileUrl;
        /**
         * 文件头行数：从头读取时要忽略的行数
         */
        private Integer fileHeaderLines;
    }
}
