package com.xxfen.myblog.service.impl;

import com.xxfen.myblog.mapper.LoginMapper;
import com.xxfen.myblog.model.db.User;
import com.xxfen.myblog.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper userMapper;


    @Override
    public User getUserByLogin(String  name,String password) {

        User user = userMapper.selectUser(name,password);
        logger.info(user + "-001");
        return user;
    }
}
