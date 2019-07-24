package com.xxfen.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxfen.myblog.mapper.ArticleMapper;
import com.xxfen.myblog.model.db.Article;
import com.xxfen.myblog.service.ArticleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public List<Article> findAllArticles(String rows, String pageNo, String categories) {
        int pageNum = Integer.parseInt(pageNo);
        int pageSize = Integer.parseInt(rows);
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleMapper.findArticleByCategories(categories);
        for (Article article :
                articles) {
            logger.info("article=" + article.toString());

        }

        logger.info("size=" + articles.size());
        logger.info("ye=" + articles.toString());
        return articles;
    }
}
