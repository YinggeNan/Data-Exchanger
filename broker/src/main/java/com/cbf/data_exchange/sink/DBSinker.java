package com.cbf.data_exchange.sink;

import com.cbf.data_exchange.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
public class DBSinker extends BaseSinker implements Sinker{

    public DBSinker(BlockingQueue<Object> readyForInsertQueue, int threadNumber,
                    DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForInsertQueue, threadNumber, config, isIntermediateProcessEnd);
    }

    @Override
    public void sink() {

    }
}
