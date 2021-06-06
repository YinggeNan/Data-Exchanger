package com.cbf.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/6
 * @description
 */
@Data
public class Broker {
    private long id;
    private long brokerId;
    private String ip;
    private int port;
    private int isDelete;
    private Timestamp createTime;
    private Timestamp updateTime;
}
