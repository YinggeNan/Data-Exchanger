package com.cbf.process;

import com.cbf.intermediateProcess.IntermediateProcess;
import com.cbf.read.BaseReader;
import com.cbf.sink.Sinker;

import java.util.concurrent.*;

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
    boolean isReadEnd = false;
    boolean isIntermediateProcessEnd = false;
    BlockingQueue<Object> readyForIntermediateProcess = null;
    BlockingQueue<Object> readyForSink = null;
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

    /**
     * 读完毕将isReadEnd置为true
     */
    public void read(){}
    /**
     * intermediateProcess完毕将isIntermediateProcessEnd置为true
     * 中间过程每个线程根据isReadEnd和决定是否关闭
     */
    public void setIntermediateProcess(){}
    /**
     * sink过程每个线程根据isIntermediateProcessEnd决定是否关闭
     */
    public void sink(){}

    /**
     * 根据config来初始必要变量
     */
    public void init(){

    }
}
