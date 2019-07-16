package com.xxfen.myblog.mapper;

import com.xxfen.myblog.model.Article;
import com.xxfen.myblog.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {


    @Select("select * from user where name=#{name} and password=#{password}")
    User selectUser(@Param("name") String  name,@Param("password")  String password);

    /**
     * 添加操作，返回新增元素的 ID
     *
     * @param user
     */
    @Insert("insert into user(name,phone,password) values(#{name},#{age},#{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(User user);
}
