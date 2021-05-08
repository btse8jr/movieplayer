package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.xander.movieplayer.util.VerifyCodeUtil.generateVerifyCode;
import static com.xander.movieplayer.util.VerifyCodeUtil.outputImage;

/**
 * Created by Xander on 2018-08-13.
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }
}
