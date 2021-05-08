package com.xander.movieplayer.service.impl;

import com.xander.movieplayer.dao.FilmRepository;
import com.xander.movieplayer.dao.FilmTypeRepository;
import com.xander.movieplayer.entity.Film;
import com.xander.movieplayer.entity.FilmType;
import com.xander.movieplayer.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 2018-08-21.
 */
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmTypeRepository filmTypeRepository;

    @Override
    public List<Film> findByLimit(int length) {
        return filmRepository.findByLimit(length);
    }

    @Override
    public List<Film> findAllOrderByFilmIdDesc() {
        return filmRepository.findAll(new Sort(Sort.Direction.DESC,"filmId"));
    }

    @Override
    public Film findByFilmId(Long filmId) {
        return filmRepository.findByFilmId(filmId);
    }

    @Override
    public List<Film> findAByCatlogId(Long catlogId) {
        return filmRepository.findByCatlogId(catlogId);
    }

    @Override
    public List<Film> findAByTypeId(Long typeId) {
        List<Film> films=new ArrayList<>();
        List<FilmType> filmTypes=filmTypeRepository.getByTypeId(typeId);
        for(FilmType filmType:filmTypes){
            films.add(filmType.getFilm());
        }
        return films;
    }
}
