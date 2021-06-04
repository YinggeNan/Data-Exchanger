package com.cbf.timer;

import com.cbf.constant.TaskTypeEnum;
import com.cbf.util.CronUtil;
import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/3
 * @description
 */
@Data
public class TimerTask implements Delayed {
    private int loadTaskId;
    private long delayTime;
    private TaskTypeEnum taskTypeEnum;
    private String cronExpression;

    @Override
    public long getDelay(TimeUnit unit) {
        return delayTime;
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS));
    }
    public TimerTask(int loadTaskId, String cronExpression, TaskTypeEnum taskTypeEnum){
        this.loadTaskId = loadTaskId;
        this.cronExpression = cronExpression;
        this.taskTypeEnum = taskTypeEnum;
        this.delayTime = calculateDelayTime();
    }
    public void updateDelayTime(){
        this.delayTime = calculateDelayTime();
    }
    public long calculateDelayTime(){
        return CronUtil.getNextTriggerTimeStamp(cronExpression) - System.currentTimeMillis();
    }
}
