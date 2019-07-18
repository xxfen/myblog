package com.xxfen.myblog.mapper;

import com.xxfen.myblog.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface ArticleMapper {

    @Select("select id from article where articleId=#{id}")
    Article selectArticle(long id);


    /**
     * 通过分类查找
     *
     * @param categories
     * @return
     */
    @Select("select id from article where articleCategories=#{categories}")
    List<Article> findArticleByCategories(String categories);

    /**
     * 通过标签查找
     *
     * @param tags
     * @return
     */
    @Select("select id from article where articleTags=#{tags}")
    List<Article> findArticleByTags(long tags);


    @Insert("insert into article(articleId,author,imgPath,articleTitle,publishDate,updateDate,articleContent,articleTags,articleCategories,articleUrl,articleTabloid,likes,lastArticleId,nextArticleId) " +
            "values(#{articleId},#{author},#{imgPath}," +
            "#{articleTitle},#{publishDate},#{updateDate}," +
            "#{articleContent},#{articleTags}," +
            "#{articleCategories},#{articleUrl},#{articleTabloid}," +
            "#{likes},#{lastArticleId},#{nextArticleId})")
    void insertArticle(Article article);
}
