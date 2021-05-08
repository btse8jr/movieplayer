package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.dto.FilmDTO;
import com.xander.movieplayer.entity.Episode;
import com.xander.movieplayer.entity.Film;
import com.xander.movieplayer.service.EpisodeService;
import com.xander.movieplayer.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.xander.movieplayer.util.FilmUtil.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 2018-08-24.
 */
@Controller
@RequestMapping("film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("all")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findAll() {
        List<Film> films=filmService.findAllOrderByFilmIdDesc();
        return new ResultBean<>(convertToFilmDTOS(films));
    }

    @GetMapping("limit")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findByLimit(int length) {
        List<Film> films=filmService.findByLimit(length);
        return new ResultBean<>(convertToFilmDTOS(films));
    }

    @GetMapping("type/{typeId}")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findByTypeId(@PathVariable Long typeId) {
        return new ResultBean<>(filmService.findAByTypeId(typeId));
    }

    @GetMapping("catlog/{catlogId}")
    @ExceptionHandler
    public String findByCatlogId(@PathVariable Long catlogId) {
        List<Film> films=filmService.findAByCatlogId(catlogId);
        return "/index";
    }

    @GetMapping("id/{filmId}")
    public String findByFilmId(@PathVariable Long filmId, Model model) {
        Film film = filmService.findByFilmId(filmId);
        int length = episodeService.countByFilmId(filmId);
        model.addAttribute("film", film);
        model.addAttribute("length", length);
        return "detail";
    }

    @GetMapping(value = "play/id/{filmId}/episode/{episodeNumber}")
    public String findBy(@PathVariable Long filmId, @PathVariable int episodeNumber, Model model) {
        Film film=filmService.findByFilmId(filmId);
        Episode episode = episodeService.findByFilmIdAndAndEpisodeNumber(filmId, episodeNumber);
        int length = episodeService.countByFilmId(filmId);
        model.addAttribute("film", film);
        model.addAttribute("episode", episode);
        model.addAttribute("length", length);
        return "play";
    }
}
