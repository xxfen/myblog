package com.xxfen.myblog.controller;

import com.xxfen.myblog.model.User;
import com.xxfen.myblog.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@Controller
@RestController
@RequestMapping("/account")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService userService;

    @RequestMapping(value ="/login", method ={ RequestMethod.POST, RequestMethod.GET})
    public String selectUser(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "password", required = true) String password) {
        logger.info(name + "-000" + password);
        User user = userService.getUserByLogin(name, password);
        if (user != null)
            return user.toString();
        else return "登陆失败！";

    }

}
