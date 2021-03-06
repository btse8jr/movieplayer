package com.xander.movieplayer.controller;

import com.xander.movieplayer.aop.ExceptionHandler;
import com.xander.movieplayer.bean.ResultBean;
import com.xander.movieplayer.entity.Catlog;
import com.xander.movieplayer.entity.Episode;
import com.xander.movieplayer.entity.Film;
import com.xander.movieplayer.entity.Type;
import com.xander.movieplayer.service.CatLogService;
import com.xander.movieplayer.service.EpisodeService;
import com.xander.movieplayer.service.FilmService;
import com.xander.movieplayer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.xander.movieplayer.util.FilmUtil.*;

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

    @Autowired
    private TypeService typeService;

    @Autowired
    private CatLogService catLogService;


    @GetMapping("all")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findAll() {
        List<Film> films = filmService.findAllOrderByFilmIdDesc();
        return new ResultBean<>(convertToFilmVOS(films));
    }

    @GetMapping("index")
    public String index(Model model) {
        List<Film> films = filmService.findAllOrderByFilmIdDesc();
        model.addAttribute("name","全部");
        model.addAttribute("filmVOS", convertToFilmVOS(films));
        return "index";
    }

    @GetMapping("limit")
    @ResponseBody
    @ExceptionHandler
    public ResultBean findByLimit(int length) {
        List<Film> films = filmService.findByLimit(length);
        return new ResultBean<>(convertToFilmVOS(films));
    }

    @GetMapping("type/{typeId}")
    public String findByTypeId(@PathVariable Long typeId, Model model) {
        List<Film> films = filmService.findAByTypeId(typeId);
        Type type=typeService.findByTypeId(typeId);
        model.addAttribute("name",type.getTypeName());
        model.addAttribute("filmVOS", convertToFilmVOS(films));
        return "index";
    }

    @GetMapping("catlog/{catlogId}")
    public String findByCatlogId(@PathVariable Long catlogId, Model model) {
        List<Film> films = filmService.findAByCatlogId(catlogId);
        Catlog catlog=catLogService.findByCatlogId(catlogId);
        model.addAttribute("name",catlog.getCatlogName());
        model.addAttribute("filmVOS", convertToFilmVOS(films));
        return "index";
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
        Film film = filmService.findByFilmId(filmId);
        Episode episode = episodeService.findByFilmIdAndAndEpisodeNumber(filmId, episodeNumber);
        int length = episodeService.countByFilmId(filmId);
        model.addAttribute("film", film);
        model.addAttribute("episode", episode);
        model.addAttribute("length", length);
        return "play";
    }
}
