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
public class TaskSchedule {
    private long id;
    private long taskId;
    private String scheduleJsonConfig;
    private int isExpired;
    private Timestamp createTime;
    private Timestamp updateTime;
}
