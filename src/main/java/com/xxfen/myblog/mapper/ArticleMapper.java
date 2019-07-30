package com.xxfen.myblog.mapper;

import com.xxfen.myblog.model.db.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface ArticleMapper {
    /*@Results({
            @Result(column = "id",property = "id"),
            @Result(column = "articleId",property = "articleId"),
            @Result(column = "articleContent",property = "articleContent"),
            @Result(column = "articleCategories",property = "articleCategories")
    })*/
    @Select("select * from article where id=#{id}")
    Article selectArticle(int id);


    /**
     * 通过分类查找
     *
     * @param categories
     * @return
     */
    @Select("select * from article where articleCategories=#{categories}")
    List<Article> findArticleByCategories(@Param("categories")String categories);

    @Select("select * from article")
    List<Article> queryArticles();

    /**
     * 通过标签查找
     *
     * @param tags
     * @return
     */
    @Select("select * from article where articleTags=#{tags}")
    List<Article> findArticleByTags(long tags);


    @Insert("insert into article(articleId,imgPath,articleTitle,publishDate,updateDate,articleContent,articleTags,articleCategories,articleTabloid)" +
            "values(#{articleId},#{imgPath}," +
            "#{articleTitle},#{publishDate},#{updateDate}," +
            "#{articleContent},#{articleTags}," +
            "#{articleCategories},#{articleTabloid}" +
            ")")
    void insertArticle(Article article);
}
