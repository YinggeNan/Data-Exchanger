package com.cbf.util;

import org.springframework.scheduling.support.CronExpression;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/3
 * @description
 */
public class CronUtil {
    public static long getNextTriggerTimeStamp(String cronExpression){
        CronExpression cron = CronExpression.parse(cronExpression);
        LocalDateTime localDateTime = LocalDateTime.now();
        return Timestamp.valueOf(cron.next(localDateTime)).getTime();
    }
    public static boolean isExpired(String cronExpression){
        long  nextTriggerTimeStamp= getNextTriggerTimeStamp(cronExpression);
        return System.currentTimeMillis() >nextTriggerTimeStamp;
    }
}
