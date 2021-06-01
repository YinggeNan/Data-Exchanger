package com.cbf.service;

import com.cbf.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
