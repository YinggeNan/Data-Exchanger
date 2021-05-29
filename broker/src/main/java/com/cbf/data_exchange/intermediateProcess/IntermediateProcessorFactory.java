package com.cbf.data_exchange.intermediateProcess;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config_enum.ReadTypeEnum;
import com.cbf.data_exchange.read.CSVFileReader;
import com.cbf.data_exchange.read.DBReader;
import com.cbf.data_exchange.read.KafkaReader;
import com.cbf.data_exchange.read.Reader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/29
 * @description
 */
public class IntermediateProcessorFactory {
    public static IntermediateProcessor constructIntermediateProcessor(BlockingQueue<Object> readyForIntermediateProcessQueue,
                                                                       BlockingQueue<Object[]> readyForSinkQueue,
                                                                       Integer threadNumber,
                                                                       DataExchangeConfig config,
                                                                       AtomicReference<Boolean> isReadEnd,
                                                                       AtomicReference<Boolean> isIntermediateProcessEnd){
        IntermediateProcessor processor = null;
        try{
            Constructor constructor = Class.forName(config.getIntermediateProcessor().
                    getIntermediateProcessClassName()).
                    getDeclaredConstructor(
                            BlockingQueue.class,
                            BlockingQueue.class,
                            Integer.class,
                            DataExchangeConfig.class,
                            AtomicReference.class,
                            AtomicReference.class);
            processor = (IntermediateProcessor)constructor.newInstance(
                    readyForIntermediateProcessQueue,
                    readyForSinkQueue,
                    threadNumber,
                    config,
                    isReadEnd,
                    isIntermediateProcessEnd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return processor;
    }
}
