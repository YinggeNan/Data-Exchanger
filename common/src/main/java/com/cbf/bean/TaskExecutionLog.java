package com.cbf.bean;

import java.sql.Timestamp;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/6
 * @description
 */
public class TaskExecutionLog {
    private long id;
    private long taskId;
    private String taskState;
    private int runningBrokerId;
    private Timestamp createTime;
    private Timestamp updateTime;
}
