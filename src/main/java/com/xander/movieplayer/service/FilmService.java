package com.xander.movieplayer.service;

import com.xander.movieplayer.entity.Film;

import java.util.List;

/**
 * Created by Xander on 2018-08-20.
 */
public interface FilmService {
    List<Film> findByLimit(int length);

    List<Film> findAllOrderByFilmIdDesc();

    Film findByFilmId(Long filmId);

    List<Film> findAByCatlogId(Long catlogId);

    List<Film> findAByTypeId(Long typeId);
}
