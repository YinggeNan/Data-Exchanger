package com.cbf.config;

import lombok.Data;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
@Data
public class DataExchangeConfig {
    private String taskName;
    private StageMeta stageMeta;
    private Sinker sinker;
    private Reader reader;
    private IntermediateProcess intermediateProcess;
    /**
     * 表明三个阶段的具体处理器
     */
    @Data
    private class StageMeta{
        /**
         * read阶段是DBReader、KafkaReader？
         */
        private String readStage;
        /**
         * intermediateProcess阶段的处理类名字
         */
        private String intermediateProcessStage;
        /**
         * sink阶段是DBSinker、kafkaSinker？
         */
        private String sinkStage;
    }
    @Data
    private class Sinker{
        private DBType dbSinker;
        private KafkaType kafkaSinker;
    }
    private class IntermediateProcess{
        private String intermediateProcessClassName;
    }
    @Data
    private class Reader{
        private DBType dbReader;
        private KafkaType kafkaReader;
    }

    private class DBType{

    }

    private class KafkaType{
        private String topicName;
        private String schemaClass;
    }

}
