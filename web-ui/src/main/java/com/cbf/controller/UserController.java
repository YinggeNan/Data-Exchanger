package com.cbf.controller;

import com.cbf.service.TaskService;
import com.cbf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value="/log-in",method = RequestMethod.POST)
    public void logIn(){

    }
    @RequestMapping(value="/log-off",method = RequestMethod.GET)
    public void logOff(){

    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public void register(){

    }
}
