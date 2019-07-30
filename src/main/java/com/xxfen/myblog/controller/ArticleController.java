package com.xxfen.myblog.controller;

import com.xxfen.myblog.model.CategoriesPageModel;
import com.xxfen.myblog.model.PageModel;
import com.xxfen.myblog.model.RspModel;
import com.xxfen.myblog.model.db.Article;
import com.xxfen.myblog.service.ArticleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@MyController
@RestController
@RequestMapping("/article")
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/{id}")
    public RspModel<Article> selectUser(@PathVariable int id) {
        logger.info(id + "-000");
        Article articleByArticleId = articleService.getArticleByArticleId(id);
        if (articleByArticleId != null)
            return RspModel.bundleOk(articleByArticleId);
        else return RspModel.bundleError(1);

    }

    @PostMapping("/publishArticle")
    @ResponseBody
//    public JSONObject publishArticle(Article article) {
    public RspModel publishArticle(@RequestBody Article article) {

        //  JSONObject json = new JSONObject();
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
        article.setArticleTabloid(article.getArticleContent());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateStr = df.format(new Date());// new Date()为获取当前系统时间        article.setPublishDate(new Date.);
        article.setPublishDate(dateStr);
        articleService.insertArticle(article);
        return RspModel.bundleOk();
        //return article.toString();
        // return   returnJson = articleService.insertArticle(article);

    }


    /**
     * 分页获得当前页文章
     *
     * @param pageModel rows   一页的大小 pageNum  当前页 categories 类别
     * @param
     */
    @PostMapping("/myArticles")
    @ResponseBody
    public RspModel<List<Article>> myArticles(@RequestBody CategoriesPageModel pageModel) {
        logger.info(pageModel.getRows() + "-" + pageModel.getPageNum() + "-" + pageModel.getCategories());
        List<Article> allArticles = articleService.findAllArticles(pageModel.getRows(), pageModel.getPageNum(), pageModel.getCategories());
        logger.info(allArticles.toString());
        return RspModel.bundleOk(allArticles);

    }

}
