package com.cbf.read;

import com.cbf.config.DataExchangeConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description 给每个独立的reader提供公共的属性
 */
public class BaseReader {
    BlockingQueue<Object> readyForIntermediateProcessQueue;
    ExecutorService readerExecutorService;
    DataExchangeConfig config;
    /**
     * 读完毕，将isConsumeEnd置为true
     */
    AtomicReference<Boolean> isConsumeEnd;
    /**
     * 从数据源读到的数据
     */
    AtomicLong readCount = new AtomicLong(0);
    public BaseReader(BlockingQueue<Object> readyForIntermediateProcessQueue,
                      int threadNumber, DataExchangeConfig config,
                      AtomicReference<Boolean> isConsumeEnd){
        this.readyForIntermediateProcessQueue = readyForIntermediateProcessQueue;
        this.readerExecutorService = Executors.newFixedThreadPool(threadNumber);
        this.config = config;
        this.isConsumeEnd = isConsumeEnd;
    }
}
