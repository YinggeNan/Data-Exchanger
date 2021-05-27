package com.cbf.sink;

import com.cbf.config.DataExchangeConfig;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
public class KafkaSinker extends BaseSinker implements Sinker{

    public KafkaSinker(BlockingQueue<Object> readyForInsertQueue, int threadNumber,
                    DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForInsertQueue, threadNumber, config, isIntermediateProcessEnd);
    }

    @Override
    public void sink() {

    }
}
