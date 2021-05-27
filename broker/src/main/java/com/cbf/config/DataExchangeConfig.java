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
    private IntermediateProcessor intermediateProcessor;
    /**
     * 表明三个阶段的处理器是哪个类型的
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

    /**
     * 根据stageMeta的的值来决定reader的属性哪个才有值
     */
    @Data
    private class Reader{
        private DataType.DBType dbReader;
        private DataType.KafkaType kafkaReader;
        private DataType.FileType fileReader;
        private int threadNumber;
    }
    /**
     * 根据stageMeta的的值来决定intermediateProcessor的属性哪个才有值
     */
    @Data
    private class IntermediateProcessor{
        private String intermediateProcessClassName;
        private int threadNumber;
    }
    /**
     * 根据stageMeta的的值来决定sinker的属性哪个才有值
     */
    @Data
    private class Sinker{
        private DataType.DBType dbSinker;
        private DataType.KafkaType kafkaSinker;
        private DataType.FileType fileSinker;
        private int threadNumber;
    }

}
