package com.cbf.data_exchange.sink;

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
 * @description 给每个独立的sinker提供公共的属性
 */
public class BaseSinker {
    BlockingQueue<Object[]> readyForSinkQueue;
    ExecutorService sinkExecutorService;
    DataExchangeConfig config;
    /**
     * intermediateProcess阶段是否完毕，为true表示完毕
     */
    AtomicReference<Boolean> isIntermediateProcessEnd;
    /**
     * 从readyForSinkQueue队列中取出的数据
     */
    AtomicLong dataCount = new AtomicLong(0);
    /**
     * sink成功的数据
     */
    AtomicLong sinkCount = new AtomicLong(0);
    int threadNumber;
    public BaseSinker(BlockingQueue<Object[]> readyForSinkQueue, int threadNumber,
                      DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd){
        this.readyForSinkQueue = readyForSinkQueue;
        this.sinkExecutorService = Executors.newFixedThreadPool(threadNumber);
        this.threadNumber = threadNumber;
        this.config = config;
        this.isIntermediateProcessEnd = isIntermediateProcessEnd;
    }
}
