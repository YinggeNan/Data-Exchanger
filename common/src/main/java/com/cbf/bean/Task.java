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
public class Task {
    private long id;
    private String taskName;
    private String readerType;
    private String readerJsonConfig;
    private String sinkerType;
    private String sinkerJsonConfig;
    private String intermediateProcessorClassName;
    private int blockingQueueSize;
    private String columnMapJsonConfig;
    private int concurrentThreadNumber;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int isDelete;
}
