package com.cbf.timer;

import com.cbf.util.CronUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/3
 * @description
 */
@Component
public class TimeScheduler {
    private static final int THREAD_NUBMER = Runtime.getRuntime().availableProcessors()*2;
    ExecutorService service = Executors.newFixedThreadPool(THREAD_NUBMER);
    DelayQueue<TimerTask> queue = new DelayQueue<>();

    public void addAndTriggerTask(TimerTask timerTask){
        queue.add(timerTask);
    }
    @PostConstruct
    public void startSchedule(){
        while(true){
            TimerTask timerTask = null;
            try {
                timerTask = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.execute(()->{

            });
            long nextTriggerTime = CronUtil.getNextTriggerTimeStamp(timerTask.getCronExpression());
            long currentTime = System.currentTimeMillis();
            timerTask.updateDelayTime();
            queue.add(timerTask);
        }
    }
}
