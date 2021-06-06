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
public class UserTask {
    private long id;
    private long userId;
    private long taskId;
    private int isDelete;
    private Timestamp createTime;
    private Timestamp updateTime;
}
