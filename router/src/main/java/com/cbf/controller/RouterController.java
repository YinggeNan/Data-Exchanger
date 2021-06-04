package com.cbf.controller;

import com.cbf.response.RouterResponse;
import com.cbf.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
@RestController
@RequestMapping("/v1/api/router")
public class RouterController {
    @Autowired
    RouterService routerService;

    /**
     * 调用一次task
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-trigger/{id}", method = RequestMethod.GET)
    public ResponseEntity<RouterResponse> taskTrigger(@PathVariable String id){
        return null;
    }

    /**
     * 暂停正在执行的task，对一个没有执行的task执行suspend操作，没有影响
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-suspend/{id}", method = RequestMethod.GET)
    public ResponseEntity<RouterResponse> taskSuspend(@PathVariable String id){
        return null;
    }

    /**
     * 恢复被暂停执行的task，对一个没有被暂停执行的task执行continue操作，没有影响
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-continue/{id}", method = RequestMethod.POST)
    public ResponseEntity<RouterResponse> taskContinue(@PathVariable String id){
        return null;
    }

    /**
     * 将cronExpression的task加入执行计划，在下次到达执行时间就执行task
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-once-add", method = RequestMethod.POST)
    public ResponseEntity<RouterResponse> taskOnceAdd(@RequestParam String id, @RequestParam String executionTime){
        return null;
    }

    /**
     * 将执行一次的task加入执行计划，在下次到达执行时间就执行task
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-cron-add", method = RequestMethod.POST)
    public ResponseEntity<RouterResponse> taskCronAdd(@RequestParam String id, @RequestParam String cronExpression){
        return null;
    }

    /**
     * 将task从执行计划中移除，对一个没有被加入执行计划中的task执行remove操作，无影响
     * @param id
     * @return
     */
    @RequestMapping(value = "/task-remove/{id}", method = RequestMethod.POST)
    public ResponseEntity<RouterResponse> taskRemove(@PathVariable String id){
        return null;
    }

}
