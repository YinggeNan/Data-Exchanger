package com.cbf.process;

import com.cbf.intermediateProcess.IntermediateProcess;
import com.cbf.read.BaseReader;
import com.cbf.sink.Sinker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class ThreeStageProcessor {
    private Sinker sinker;
    private BaseReader reader;
    private IntermediateProcess intermediateProcess;
    public ThreeStageProcessor(Sinker sinker, BaseReader reader, IntermediateProcess intermediateProcess){
        this.sinker = sinker;
        this.reader = reader;
        this. intermediateProcess = intermediateProcess;
    }
    private final int THREAD_NUMBER = 2;
    //使用一个queue来同步read、intermediaeProcess呢，还是用多个queue呢
    /**
     * 程序主流程
     */
    public void process(){
        try{
            ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);
            service.execute(()->read());
            service.execute(()->setIntermediateProcess());
            service.execute(()->sink());
            service.shutdown();
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void read(){}
    public void setIntermediateProcess(){}
    public void sink(){}
}
