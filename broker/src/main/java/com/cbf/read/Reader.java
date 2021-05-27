package com.cbf.read;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description: 每个独立的reader都需要实现Reader接口
 */
public interface Reader {
    /**
     * 从数据源（file、db、mq等）读数据
     * @return
     */
    void read();
}
