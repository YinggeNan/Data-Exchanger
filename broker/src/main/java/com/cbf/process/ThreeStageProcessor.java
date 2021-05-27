package com.cbf.process;

import com.cbf.config.DataExchangeConfig;
import com.cbf.intermediateProcess.IntermediateProcessor;
import com.cbf.read.BaseReader;
import com.cbf.read.Reader;
import com.cbf.sink.Sinker;
import com.cbf.util.CommonUtil;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class ThreeStageProcessor {
    private Sinker sinker;
    private Reader reader;
    private IntermediateProcessor intermediateProcessor;
    DataExchangeConfig config;
    public ThreeStageProcessor(Sinker sinker, Reader reader, IntermediateProcessor intermediateProcessor){
        this.sinker = sinker;
        this.reader = reader;
        this.intermediateProcessor = intermediateProcessor;
    }
    AtomicReference<Boolean> isReadEnd = new AtomicReference<>(false);
    AtomicReference<Boolean> isIntermediateProcessEnd = new AtomicReference<>(false);
    BlockingQueue<Object> readyForIntermediateProcess = null;
    BlockingQueue<Object> readyForSink = null;
    private final int THREAD_NUMBER = 2;
    //使用一个queue来同步read、intermediaeProcess呢，还是用多个queue呢
    /**
     * 程序主流程
     */
    public void process(){
        init();
        try{
            ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);
            service.execute(()->reader.read());
            service.execute(()->intermediateProcessor.intermediateProcess());
            service.execute(()->sinker.sink());
            service.shutdown();
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据config来初始必要变量
     */
    public void init(){
        config = CommonUtil.deseriaze();
        sinker = null;
        reader = null;
    }
}
