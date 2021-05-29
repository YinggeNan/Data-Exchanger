package com.cbf.data_exchange.intermediateProcess;

import com.cbf.data_exchange.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description 给每个独立的intermediatProcessor提供公共的属性
 */
public class BaseIntermediatProcessor {
    BlockingQueue<Object> readyForIntermediateProcessQueue;
    BlockingQueue<Object> readyForSinkQueue;
    ExecutorService intermediateProcessExecutorService;
    DataExchangeConfig config;
    /**
     * read阶段是否完毕，为true表示完毕
     */
    AtomicReference<Boolean> isReadEnd;
    /**
     * 中间处理完毕，将isIntermediateProcessEnd置为true
     */
    AtomicReference<Boolean> isIntermediateProcessEnd;
    /**
     * 从readyForIntermediateProcessQueue中取到的数据
     */
    AtomicLong dataCount;
    /**
     * 中间处理成功或者放入readyForSinkQueue中的数据
     */
    AtomicLong intermediateCount;
    public BaseIntermediatProcessor(BlockingQueue<Object> readyForIntermediateProcessQueue,
                                    BlockingQueue<Object> readyForSinkQueue,
                                    Integer threadNumber, DataExchangeConfig config,
                                    AtomicReference<Boolean> isConsumeEnd,
                                    AtomicReference<Boolean> isIntermediateProcessEnd){
        this.readyForIntermediateProcessQueue = readyForIntermediateProcessQueue;
        this.readyForSinkQueue = readyForSinkQueue;
        this.intermediateProcessExecutorService = Executors.newFixedThreadPool(threadNumber);
        this.config = config;
        this.isReadEnd = isConsumeEnd;
        this.isIntermediateProcessEnd = isIntermediateProcessEnd;
    }
}
