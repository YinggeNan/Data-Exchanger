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
public class KafkaSinker extends BaseSinker implements Sinker{

    public KafkaSinker(BlockingQueue<Object[]> readyForSinkQueue, int threadNumber,
                    DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForSinkQueue, threadNumber, config, isIntermediateProcessEnd);
    }

    @Override
    public void sink() {

    }
}
