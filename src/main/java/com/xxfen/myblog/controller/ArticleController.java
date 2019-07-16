package com.xxfen.myblog.controller;

import com.xxfen.myblog.model.Article;
import com.xxfen.myblog.service.ArticleService;
import com.xxfen.myblog.util.FileUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


//@MyController
@RestController
@RequestMapping("/article")
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/{id}")
    public String selectUser(@PathVariable long id) {
        logger.info(id + "-000");
        Article articleByArticleId = articleService.getArticleByArticleId(id);
        if (articleByArticleId != null)
            return articleByArticleId.toString();
        else return "无数据！";

    }

    @PostMapping("/publishArticle")
    @ResponseBody
    public JSONObject selectUser(@PathVariable Article article) {

        JSONObject returnJson = new JSONObject();
      return   returnJson = articleService.insertArticle(article);

    }
}
