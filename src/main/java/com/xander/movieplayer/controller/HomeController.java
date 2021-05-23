package com.xander.movieplayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.xander.movieplayer.util.VerifyCodeUtil.generateVerifyCode;
import static com.xander.movieplayer.util.VerifyCodeUtil.outputImage;

/**
 * Created by Xander on 2018-08-13.
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(){
        return "forward:/film/index";
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
