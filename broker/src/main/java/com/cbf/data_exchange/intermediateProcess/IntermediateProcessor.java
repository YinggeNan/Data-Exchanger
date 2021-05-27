package com.cbf.data_exchange.intermediateProcess;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description: 每个独立的intermediateProcessor都需要实现IntermediateProcessor接口
 */
public interface IntermediateProcessor {
    /**
     * 中间处理阶段数据
     */
    void intermediateProcess();
}
