package com.cbf.data_exchange.read;

import com.cbf.data_exchange.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
public class DBReader extends BaseReader implements  Reader{


    public DBReader(BlockingQueue<Object> readyForIntermediateProcessQueue, int threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isConsumeEnd) {
        super(readyForIntermediateProcessQueue, threadNumber, config, isConsumeEnd);
    }

    @Override
    public void read() {

    }
}
