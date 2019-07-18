package com.xxfen.myblog.service;

import com.xxfen.myblog.model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: zhangocean
 * @Date: 2018/7/18 12:07
 * Describe: 归档业务操作
 */
public interface ArticleService {
    /**
     * 保存文章
     * @param article 文章
     * @return  status: 200--成功   500--失败
     */

    JSONObject insertArticle(Article article);

    /**
     * 修改文章
     * @return
     */
    @Transactional
    JSONObject updateArticleById(Article article);

    /**
     * 获得文章
     * @param articleId 文章id
     * @return
     */
    Article getArticleByArticleId(long articleId);


    /**
     * 按分类并分页获得所有文章
     * @param rows 一页显示文章数
     * @param pageNo 第几页
     * @return 该页所有文章
     */
    JSONArray findAllArticles(String rows, String pageNo,String categories);}
