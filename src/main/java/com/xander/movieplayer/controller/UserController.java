package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.dto.UserDTO;
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

    @GetMapping("login")
    @ResponseBody
    @ExceptionHandler
    public ResultBean login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        session.setAttribute("user",user);
        return new ResultBean();
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("register")
    @ResponseBody
    @ExceptionHandler
    public ResultBean register(UserDTO userDTO,HttpSession session){
        userDTO.setVerCode((String) session.getAttribute("verCode"));
        userService.register(userDTO);
        return new ResultBean();
    }

    @GetMapping("check")
    @ResponseBody
    @ExceptionHandler
    public ResultBean check(String username){
        userService.exist(username);
        return new ResultBean();
    }
}
