package com.xxfen.myblog.model.db;


import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author: zhangocean
 * @Date: 2018/6/20 15:34
 * Describe: 文章
 */

public class Article {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 文章id
     */
    private long articleId;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章封面图
     */
    private String imgPath;

    /**
     * 文章名
     */
    private String articleTitle;

    /**
     * 发布时间
     */
    private String publishDate;

    /**
     * 最后一次修改时间
     */
    private String updateDate;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章标签
     */
    private String articleTags;


    /**
     * 博客分类
     */
    private String articleCategories;


    /**
     * 原文链接
     * 转载：则是转载的链接
     * 原创：则是在本博客中的链接
     */
//    private String articleUrl;

    /**
     * 文章摘要
     */
    private String articleTabloid;

    /*    *//**
     * 上一篇文章id
     *//*
    private long lastArticleId;

    *//**
     * 下一篇文章id
     *//*
    private long nextArticleId;*/

    /**
     * 喜欢
     */
    private int likes = 0;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags;
    }


    public String getArticleCategories() {
        return articleCategories;
    }

    public void setArticleCategories(String articleCategories) {
        this.articleCategories = articleCategories;
    }


    public String getArticleTabloid() {
        return articleTabloid;
    }

    public void setArticleTabloid(String articleTabloid) {
        this.articleTabloid = articleTabloid;
    }


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", author='" + author + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleTags='" + articleTags + '\'' +
                ", articleCategories='" + articleCategories + '\'' +
               // ", articleUrl='" + articleUrl + '\'' +
                ", articleTabloid='" + articleTabloid + '\'' +

                ", likes=" + likes +
                '}';
    }

}
