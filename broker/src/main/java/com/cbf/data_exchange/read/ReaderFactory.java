package com.cbf.data_exchange.read;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config_enum.ReadTypeEnum;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/29
 * @description
 */
public class ReaderFactory {
    public static Reader constructReader(ReadTypeEnum typeEnum, BlockingQueue<Object> readyForIntermediateProcessQueue,
                                         int threadNumber, DataExchangeConfig config,
                                         AtomicReference<Boolean> isReadEnd){
        switch (typeEnum){
            case DB_Reader:
                return new DBReader(readyForIntermediateProcessQueue,
                        threadNumber, config, isReadEnd);
            case KAFKA_Reader:
                return new KafkaReader(readyForIntermediateProcessQueue,
                        threadNumber, config, isReadEnd);
            case FILE_Reader:
                return new CSVFileReader(readyForIntermediateProcessQueue,
                        threadNumber, config, isReadEnd);
            default:
                break;
        }
        return null;
    }
}
