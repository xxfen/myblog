package com.xxfen.myblog.controller;

import com.xxfen.myblog.model.Article;
import com.xxfen.myblog.service.ArticleService;
import com.xxfen.myblog.util.FileUtil;
import org.json.JSONArray;
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
//    public JSONObject publishArticle(Article article) {
    public String publishArticle(@RequestBody Article article) {

        JSONObject returnJson = new JSONObject();
        logger.info(article.toString() + "-0001");
        String str = "{\n" +
                "\t\"articleTitle\": " + article.getArticleTitle() + ",\n" +
                "\t\"articleContent\":  " + article.getArticleContent() +
                ",\n" +
                "\t\"articleTags\": " + article.getArticleTags() +
                ",\n" +
                "\t\"articleCategories\": " + article.getArticleCategories() +
                ",\n" +
                "\t\"imgPath\": " + article.getImgPath() +
                "\n" +
                "}";

        return str;
        //return article.toString();
        // return   returnJson = articleService.insertArticle(article);

    }


    /**
     * 分页获得当前页文章
     *
     * @param rows       一页的大小
     * @param pageNum    当前页
     * @param categories 类别
     */
    @PostMapping("/myArticles")
     @ResponseBody
    public   JSONArray myArticles(@RequestParam(value = "rows", required = false) String rows,
                         @RequestParam(value = "pageNum", required = false) String pageNum,
                         @RequestParam(value = "categories", required = false) String categories) {
        logger.info(rows + "-" + pageNum + "-" + categories);
        return articleService.findAllArticles(rows, pageNum, categories);

    }

}
