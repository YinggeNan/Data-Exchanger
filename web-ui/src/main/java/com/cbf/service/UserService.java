package com.cbf.service;

import com.cbf.daos.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
@Service
public class UserService {
    @Autowired
    UserDao dao;
}
