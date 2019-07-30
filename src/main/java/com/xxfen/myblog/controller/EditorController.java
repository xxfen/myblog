package com.xxfen.myblog.controller;

import com.xxfen.myblog.util.FileUtil;
import com.xxfen.myblog.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EditorController {
    private Logger logger = LoggerFactory.getLogger(EditorController.class);

    /**
     * 文章编辑本地上传图片
     */
    @RequestMapping("/uploadImage")
    public @ResponseBody
    Map<String, Object> uploadImage(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            request.setCharacterEncoding("utf-8");
            //设置返回头后页面才能获取返回url
            response.setHeader("X-Frame-Options", "SAMEORIGIN");

            FileUtil fileUtil = new FileUtil();
            String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/");
            String filePath = this.getClass().getResource("/").getPath().substring(1) + "blogImg/";
            /**
             * 文件路径不存在则需要创建文件路径
             */
         /*   File filePath1=new File(rootPath);
            if(!filePath1.exists()){
                filePath1.mkdirs();
            }*/


            logger.info(rootPath);

            String fileContentType = file.getContentType();
            String fileExtension = fileContentType.substring(fileContentType.indexOf("/") + 1);
            TimeUtil timeUtil = new TimeUtil();
            String fileName = file.getName() + timeUtil.getLongTime() + "." + fileExtension;

            String subCatalog = "blogArticles/" + new TimeUtil().getFormatDateForThree();
            File file1 = fileUtil.multipartFileToFile(file, filePath, fileName);
//
            logger.info(filePath + fileName);

            String fileUrl = "blogImg/" + file1.getName();
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功");
            resultMap.put("url", filePath + fileName);
        } catch (Exception e) {
            try {
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return resultMap;
    }


    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public void hello(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/");

            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            //最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            // FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write("{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/resources/upload/" + attach.getOriginalFilename() + "\"}");
        } catch (Exception e) {
            try {
                response.getWriter().write("{\"success\":0}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
