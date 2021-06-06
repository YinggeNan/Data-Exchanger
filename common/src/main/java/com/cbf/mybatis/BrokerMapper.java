package com.cbf.mybatis;

import com.cbf.bean.Broker;

import java.util.List;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/6
 * @description
 */
public interface BrokerMapper {
    /**
     * 获取所有的broker
     * @return
     */
    List<Broker> selectAll();
}
