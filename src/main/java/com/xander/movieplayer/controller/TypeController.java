package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.service.TypeService;
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
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("id/{typeId}")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findByTypeId(@PathVariable Long typeId){
        return new ResultBean<>(typeService.findByTypeId(typeId));
    }

    @GetMapping("all")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findAll(){
        return new ResultBean<>(typeService.findAll());
    }
}
