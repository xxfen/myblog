package com.xxfen.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxfen.myblog.mapper.ArticleMapper;
import com.xxfen.myblog.model.Article;
import com.xxfen.myblog.service.ArticleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {
    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public JSONObject insertArticle(Article article) {
        articleMapper.insertArticle(article);
        return null;
    }

    @Override
    public JSONObject updateArticleById(Article article) {
        return null;
    }

    @Override
    public Article getArticleByArticleId(long articleId) {
        logger.info(articleId + "-001");
        Article a = articleMapper.selectArticle(articleId);
        logger.info(a + "-001");
        return a;
    }

    @Override
    public JSONArray findAllArticles(String rows, String pageNo, String categories) {
        int pageNum = Integer.parseInt(pageNo);
        int pageSize = Integer.parseInt(rows);
        PageHelper.startPage(pageNum, pageSize);
        articleMapper.findArticleByCategories(categories);
        return null;
    }
}
