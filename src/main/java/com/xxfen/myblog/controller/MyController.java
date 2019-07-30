package com.xxfen.myblog.controller;

import com.xxfen.myblog.model.db.Article;
import com.xxfen.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 编辑页
     *
     * @return
     */
    @RequestMapping("/edit")
    public String getText() {

        return "edit";
    }

    /**
     * 关于页
     *
     * @return
     */
    @RequestMapping("/about")
    public String about() {

        return "about";
    }

    /**
     * 说说
     *
     * @return
     */
    @RequestMapping("/whisper")
    public String whisper() {

        return "whisper";
    }

    /**
     * 留言
     *
     * @return
     */
    @RequestMapping("/leacots")
    public String leacots() {

        return "leacots";
    }

    /**
     * 相册
     *
     * @return
     */
    @RequestMapping("/album")
    public String album() {

        return "album";
    }

    /**
     * 文章
     *
     * @return
     */
    // @RequestMapping("/details")
    @GetMapping("/details/{id}")
    public String show(@PathVariable("id") int articleId,
                       HttpServletResponse response,
                       Model model,
                       HttpServletRequest request) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getSession().removeAttribute("lastUrl");

        Article article = articleService.getArticleByArticleId(articleId);

        model.addAttribute("articleTitle", article.getArticleTitle());
        String articleTabloid = article.getArticleTabloid();
        if (articleTabloid.length() <= 110) {
            model.addAttribute("articleTabloid", articleTabloid);
        } else {
            model.addAttribute("articleTabloid", articleTabloid.substring(0, 110));
        }

        //将文章id存入响应头
        response.setHeader("articleId", String.valueOf(articleId));

        return "article";
    }
}
