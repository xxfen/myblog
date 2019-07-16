package com.xxfen.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class HelloWordController {
    @RequestMapping("/hello")
    public String index() {

        return "Hello Word";
    }



}
