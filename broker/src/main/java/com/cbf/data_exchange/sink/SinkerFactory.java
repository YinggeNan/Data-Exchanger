package com.cbf.data_exchange.sink;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config_enum.ReadTypeEnum;
import com.cbf.data_exchange.config_enum.SinkTypeEnum;
import com.cbf.data_exchange.read.CSVFileReader;
import com.cbf.data_exchange.read.DBReader;
import com.cbf.data_exchange.read.KafkaReader;
import com.cbf.data_exchange.read.Reader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/29
 * @description
 */
public class SinkerFactory {
    public static Sinker constructReader(SinkTypeEnum typeEnum, BlockingQueue<Object> readyForIntermediateProcessQueue,
                                         int threadNumber, DataExchangeConfig config,
                                         AtomicReference<Boolean> isIntermediateProcessEnd){
        switch (typeEnum){
            case DB_SINKER:
                return new DBSinker(readyForIntermediateProcessQueue,
                        threadNumber, config, isIntermediateProcessEnd);
            case KAFKA_SINKER:
                return new KafkaSinker(readyForIntermediateProcessQueue,
                        threadNumber, config, isIntermediateProcessEnd);
            case FILE_SINKER:
                return new CSVFileSinker(readyForIntermediateProcessQueue,
                        threadNumber, config, isIntermediateProcessEnd);
            default:
                break;
        }
        return null;
    }
}
