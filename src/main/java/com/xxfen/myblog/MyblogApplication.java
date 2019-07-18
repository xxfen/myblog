package com.xxfen.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;


//@MapperScan("com.xxfen.myblog.mapper")
@SpringBootApplication
public class MyblogApplication {
    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

    /**
     * 查看用了什么数据库连接池
     */
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource + "-00011");
    }

}
