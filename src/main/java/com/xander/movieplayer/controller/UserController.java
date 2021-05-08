package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.entity.User;
import com.xander.movieplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Xander on 2018-08-22.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @GetMapping
    @ResponseBody
    @ExceptionHandler
    public ResultBean login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        session.setAttribute("user",user);
        return new ResultBean();
    }

    @RequestMapping("logout")
    @GetMapping
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping("register")
    @PostMapping
    @ResponseBody
    @ExceptionHandler
    public ResultBean register(User user){
        user.setPermission(0);
        userService.register(user);
        return new ResultBean();
    }
}
