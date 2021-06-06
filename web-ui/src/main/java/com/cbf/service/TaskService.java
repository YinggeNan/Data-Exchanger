package com.cbf.service;

import com.cbf.daos.MybatisConfig;
import com.cbf.daos.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
@Service
public class TaskService {
    @Autowired
    TaskDao dao;
    public void selectTasks(){
    }
    @PostConstruct
    public void hello(){
        new MybatisConfig().test();
    }
}
