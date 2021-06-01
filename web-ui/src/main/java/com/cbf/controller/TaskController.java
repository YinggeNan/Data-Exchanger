package com.cbf.controller;

import com.cbf.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/v1/api/tasks")
public class TaskController {
    @Autowired
    TaskService service;

    /**
     * select task list
     */
    @RequestMapping(method = RequestMethod.GET)
    public void selectTasks(){

    }

    /**
     * select task by id
     * @param id
     */
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public void selectTaskById(@PathVariable String id){

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
     *  check proces of task
     */
    @RequestMapping(value="/{id}/process",method = RequestMethod.GET)
    public void checkProcess(@PathVariable String id){

    }
}
