package com.cbf.controller;

import com.cbf.bean.Task;
import com.cbf.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 * restful api 参考:http://restful.p2hp.com/search
 */
@Slf4j
@RestController
@RequestMapping("/v1/api/tasks")
public class TaskController {
    @Autowired
    TaskService service;

    /**
     * select task list
     * ResponseEntity的使用：https://blog.csdn.net/neweastsun/article/details/81142870
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Task> selectTasks(){
        return new ResponseEntity<Task>(HttpStatus.OK);
    }

    /**
     * select task by id
     * @param id
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public void selectTaskById(@PathVariable String id){
        System.out.println();
    }

    /**
     * update task by id
     * @param id
     */
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public void updateTask(@PathVariable String id){

    }

    /**
     * delete task by id
     * @param id
     */
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable String id){

    }

    /**
     * add task
     */
    @RequestMapping(method = RequestMethod.POST)
    public void addTask(@PathVariable String id){

    }

    /**
     * trigger task by id
     */
    @RequestMapping(value="/{id}/trigger",method = RequestMethod.GET)
    public void triggerTask(@PathVariable String id){

    }

    /**
     * suspend task by id
     */
    @RequestMapping(value="/{id}/suspend",method = RequestMethod.GET)
    public void suspendTask(@PathVariable String id){

    }

    /**
     *  continue task by id
     */
    @RequestMapping(value="/{id}/continue",method = RequestMethod.GET)
    public void continueTask(@PathVariable String id){

    }

    /**
     *  check task status by id
     */
    @RequestMapping(value="/{id}/status",method = RequestMethod.GET)
    public void checkStatus(@PathVariable String id){

    }

    /**
     *  select logs of task execution
     */
    @RequestMapping(value="/{id}/task-log",method = RequestMethod.GET)
    public void selectTaskLogById(@PathVariable String id){

    }
    /**
     *  check process of task
     */
    @RequestMapping(value="/{id}/process",method = RequestMethod.GET)
    public void checkProcess(@PathVariable String id){

    }
}
