package com.xxfen.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    /**
     * 文章 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    /**
     * 编辑页
     *
     * @return
     */
    @RequestMapping("/edit")
    public String getText() {

        return "edit";
    }

    /**
     * 编辑页
     *
     * @return
     */
    @RequestMapping("/about")
    public String about() {

        return "about";
    }

    /**
     * 说说
     *
     * @return
     */
    @RequestMapping("/whisper")
    public String whisper() {

        return "whisper";
    }

    /**
     * 留言
     *
     * @return
     */
    @RequestMapping("/leacots")
    public String leacots() {

        return "leacots";
    }

    /**
     * 相册
     *
     * @return
     */
    @RequestMapping("/album")
    public String album() {

        return "album";
    }

    /**
     * 文章
     *
     * @return
     */
    @RequestMapping("/details")
    public String details() {

        return "details";
    }
}
