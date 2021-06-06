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
public class User {
    private long id;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userQqNumber;
    private String userWeiXinNumber;
    private int isDelete;
    private int isVip;
    private Timestamp createTime;
    private Timestamp updateTime;
}
