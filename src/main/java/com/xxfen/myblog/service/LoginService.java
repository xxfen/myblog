package com.xxfen.myblog.service;

import com.xxfen.myblog.model.db.User;


/**
 * @author: zhangocean
 * @Date: 2018/7/18 12:07
 * Describe: 归档业务操作
 */
public interface LoginService {


    /**
     * 获得用户
     * @param name 用户名
     * @param password 密码
     * @return
     */
    User getUserByLogin(String  name,String password);

}
