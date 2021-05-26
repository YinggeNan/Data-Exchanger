package com.cbf.process;

import com.cbf.intermediateProcess.IntermediateProcess;
import com.cbf.read.BaseReader;
import com.cbf.sink.Sinker;

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
    //使用一个queue来同步read、intermediaeProcess呢，还是用多个queue呢
    /**
     * 程序主流程
     */
    public void process(){

    }
}
