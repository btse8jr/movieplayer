package com.xander.movieplayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Properties;

import static com.xander.movieplayer.util.VerifyCodeUtil.generateVerifyCode;
import static com.xander.movieplayer.util.VerifyCodeUtil.outputImage;

/**
 * Created by Xander on 2018-08-09.
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

    @GetMapping("/auth")
    @ResponseBody
    public void authImage(HttpServletResponse response, HttpSession session) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image");
        session.removeAttribute("verCode");
        String code = generateVerifyCode(4);
        session.setAttribute("verCode", code.toLowerCase());
        //生成图片
        int w = 100, h = 40;
        outputImage(w, h, response.getOutputStream(), code);
    }

    @GetMapping("mp4/{path:.+}")
    @ResponseBody
    public void mp4(@PathVariable String path, HttpServletResponse response) throws Exception {
        Properties p = new Properties();
        p.load(ResourceController.class.getResourceAsStream("/videopath.properties"));
        String basePath = p.get("path").toString();
        String realPath = basePath + path.replaceAll("_", "/");
        response.setContentType("video/mp4");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Etag", "W/\"9767057-1323779115364\"");
        File file = new File(realPath);
        ServletOutputStream out = response.getOutputStream();
        InputStream in = new FileInputStream(file);
        response.setContentLength(in.available());
        byte[] b = null;
        while (in.available() > 0) {
            if (in.available() > 10240) {
                b = new byte[10240];
            } else {
                b = new byte[in.available()];
            }
            in.read(b, 0, b.length);
            out.write(b, 0, b.length);
        }
        in.close();
        out.flush();
        out.close();
    }

    @GetMapping("flv/{path:.+}")
    @ResponseBody
    public void flv(@PathVariable String path, HttpServletResponse response) throws Exception {
        Properties p = new Properties();
        p.load(ResourceController.class.getResourceAsStream("/videopath.properties"));
        String basePath = p.get("path").toString();
        String realPath = basePath + path.replaceAll("_", "/");
        response.setContentType("video/flv");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Etag", "W/\"9767057-1323779115364\"");
        File file = new File(realPath);
        ServletOutputStream out = response.getOutputStream();
        InputStream in = new FileInputStream(file);
        response.setContentLength(in.available());
        byte[] b = null;
        while (in.available() > 0) {
            if (in.available() > 10240) {
                b = new byte[10240];
            } else {
                b = new byte[in.available()];
            }
            in.read(b, 0, b.length);
            out.write(b, 0, b.length);
        }
        in.close();
        out.flush();
        out.close();
    }

}
