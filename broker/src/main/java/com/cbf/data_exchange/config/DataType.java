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
    protected static class DBType{
        private String dbType;
        private String driverClass;
        private String url;
        private String userName;
        private String password;
        private String dbName;
    }
    @Data
    protected static class KafkaType{
        private String topicName;
        private String schemaClass;
    }
    protected static class FileType{
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
