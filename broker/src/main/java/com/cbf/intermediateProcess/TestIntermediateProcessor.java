package com.cbf.intermediateProcess;

import com.cbf.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class TestIntermediateProcessor extends BaseIntermediatProcessor implements  IntermediateProcessor{

    public TestIntermediateProcessor(BlockingQueue<Object> readyForIntermediateProcessQueue, int threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isConsumeEnd, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForIntermediateProcessQueue, threadNumber, config, isConsumeEnd, isIntermediateProcessEnd);
    }

    @Override
    public void intermediateProcess() {

    }
}
