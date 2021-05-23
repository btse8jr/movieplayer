package com.xander.movieplayer.util;

import com.xander.movieplayer.vo.FilmVO;
import com.xander.movieplayer.entity.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 2018-08-29.
 */
public class FilmUtil {
    public static FilmVO convertToFilmVO(Film film){
        FilmVO filmVO=new FilmVO();
        filmVO.setFilmId(film.getFilmId());
        filmVO.setFilmName(film.getFilmName());
        filmVO.setActor(film.getActor());
        filmVO.setCover(film.getCover());
        filmVO.setDoubanStar(film.getDoubanStar());
        filmVO.setStatus(film.getStatus());
        return filmVO;
    }

    public static List<FilmVO> convertToFilmVOS(List<Film> films){
        List<FilmVO> filmVOS=new ArrayList<>();
        FilmVO filmVO;
        for(Film film:films){
            filmVO=new FilmVO();
            filmVO.setFilmId(film.getFilmId());
            filmVO.setFilmName(film.getFilmName());
            filmVO.setActor(film.getActor());
            filmVO.setCover(film.getCover());
            filmVO.setDoubanStar(film.getDoubanStar());
            filmVO.setStatus(film.getStatus());
            filmVOS.add(filmVO);
        }
        return filmVOS;
    }
}
