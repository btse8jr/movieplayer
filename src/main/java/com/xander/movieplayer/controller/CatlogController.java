package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.service.CatLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xander on 2018-08-24.
 */
@Controller
@RequestMapping("catlog")
public class CatlogController {
    @Autowired
    private CatLogService catLogService;

    @GetMapping("id/{catlogId}")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findByCatlogId(@PathVariable Long catlogId){
        return new ResultBean<>(catLogService.findByCatlogId(catlogId));
    }

    @GetMapping("all")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findAll(){
        return new ResultBean<>(catLogService.findAll());
    }
}
