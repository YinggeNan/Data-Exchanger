package com.cbf.sink;

import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description: 每个独立的sinker都需要实现Sinker接口
 */
public interface Sinker {
    /**
     * 将一批数据sink到目标数据仓库（file、db、mq等）
     * @param list
     * @return
     */
    void sink();
}
