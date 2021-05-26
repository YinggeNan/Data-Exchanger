package com.cbf.read;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class BaseReader {
    BlockingQueue<Object> readyForIntermediateProcessQueue;
    public BaseReader(int queueSize){
        this.readyForIntermediateProcessQueue = new LinkedBlockingQueue<>(queueSize);
    }
}
