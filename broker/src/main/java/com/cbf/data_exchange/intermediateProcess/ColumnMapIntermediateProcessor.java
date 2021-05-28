package com.cbf.data_exchange.intermediateProcess;

import com.cbf.data_exchange.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class ColumnMapIntermediateProcessor extends BaseIntermediatProcessor implements  IntermediateProcessor{
    public ColumnMapIntermediateProcessor(BlockingQueue<Object> readyForIntermediateProcessQueue, int threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isConsumeEnd, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForIntermediateProcessQueue, threadNumber, config, isConsumeEnd, isIntermediateProcessEnd);
    }

    @Override
    public void intermediateProcess() {

    }
}
