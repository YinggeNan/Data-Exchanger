package com.cbf.data_exchange.process;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config_enum.ReadTypeEnum;
import com.cbf.data_exchange.config_enum.SinkTypeEnum;
import com.cbf.data_exchange.intermediateProcess.IntermediateProcessorFactory;
import com.cbf.data_exchange.intermediateProcess.IntermediateProcessor;
import com.cbf.data_exchange.read.Reader;
import com.cbf.data_exchange.read.ReaderFactory;
import com.cbf.data_exchange.sink.Sinker;
import com.cbf.data_exchange.sink.SinkerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description 每一个ThreeStageProcessor都对应一个完成的task
 */
public class ThreeStageProcessor {
    private Sinker sinker;
    private Reader reader;
    private IntermediateProcessor intermediateProcessor;
    AtomicReference<Boolean> isReadEnd = new AtomicReference<>(false);
    AtomicReference<Boolean> isIntermediateProcessEnd = new AtomicReference<>(false);
    BlockingQueue<Object> readyForIntermediateProcess = null;
    BlockingQueue<Object> readyForSink = null;
    private final int THREAD_NUMBER = 2;
    //使用一个queue来同步read、intermediaeProcess呢，还是用多个queue呢
    /**
     * 程序主流程
     */
    public void process(DataExchangeConfig config){
        initAndconstructComponent(config);
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
    private void initAndconstructComponent(DataExchangeConfig config){
        readyForIntermediateProcess = new LinkedBlockingDeque<>(config.getBlockingQueueSize());
        readyForSink = new LinkedBlockingDeque<>(config.getBlockingQueueSize());
        DataExchangeConfig.StageMeta stageMeta =config.getStageMeta();
        SinkTypeEnum sinkTypeEnum = SinkTypeEnum.getEnum(stageMeta.getSinkStage());
        ReadTypeEnum readTypeEnum = ReadTypeEnum.getEnum(stageMeta.getReadStage());
        reader = ReaderFactory.constructReader(readTypeEnum, readyForIntermediateProcess,
                1, config, isReadEnd);
        int sinkThreadNumber = Runtime.getRuntime().availableProcessors()*2;
        sinker = SinkerFactory.constructReader(sinkTypeEnum, readyForSink, sinkThreadNumber,
                config, isIntermediateProcessEnd);
        intermediateProcessor = IntermediateProcessorFactory.constructIntermediateProcessor(
                readyForIntermediateProcess,
                readyForSink,
                1,
                config,
                isReadEnd,
                isIntermediateProcessEnd);
    }
}
