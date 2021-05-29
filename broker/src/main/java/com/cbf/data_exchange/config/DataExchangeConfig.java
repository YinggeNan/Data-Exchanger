package com.cbf.data_exchange.config;

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
    private IntermediateProcessor intermediateProcessor;
    private Integer blockingQueueSize;
    /**
     * json文件,平铺类型，没有嵌套:{sinkColumnName:readColumnName}
     */
    private String columnMapFilePath;
    /**
     * 表明三个阶段的处理器是哪个类型的
     */
    @Data
    public static class StageMeta{
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

    /**
     * 根据stageMeta的的值来决定reader的属性哪个才有值
     */
    @Data
    public static class Reader{
        private DataType.DBType dbReader;
        private DataType.KafkaType kafkaReader;
        private DataType.FileType fileReader;
    }
    /**
     * 根据stageMeta的的值来决定intermediateProcessor的属性哪个才有值
     */
    @Data
    public static class IntermediateProcessor{
        private String intermediateProcessClassName;
    }
    /**
     * 根据stageMeta的的值来决定sinker的属性哪个才有值
     */
    @Data
    public static class Sinker{
        private DataType.DBType dbSinker;
        private DataType.KafkaType kafkaSinker;
        private DataType.FileType fileSinker;
    }

}
