package com.xander.movieplayer.util;

import com.xander.movieplayer.dto.FilmDTO;
import com.xander.movieplayer.entity.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 2018-08-29.
 */
public class FilmUtil {
    public static FilmDTO convertToFilmDTO(Film film){
        FilmDTO filmDTO=new FilmDTO();
        filmDTO.setFilmId(film.getFilmId());
        filmDTO.setFilmName(film.getFilmName());
        filmDTO.setActor(film.getActor());
        filmDTO.setCover(film.getCover());
        filmDTO.setDoubanStar(film.getDoubanStar());
        filmDTO.setStatus(film.getStatus());
        return filmDTO;
    }

    public static List<FilmDTO> convertToFilmDTOS(List<Film> films){
        List<FilmDTO> filmDTOS=new ArrayList<>();
        FilmDTO filmDTO;
        for(Film film:films){
            filmDTO=new FilmDTO();
            filmDTO.setFilmId(film.getFilmId());
            filmDTO.setFilmName(film.getFilmName());
            filmDTO.setActor(film.getActor());
            filmDTO.setCover(film.getCover());
            filmDTO.setDoubanStar(film.getDoubanStar());
            filmDTO.setStatus(film.getStatus());
            filmDTOS.add(filmDTO);
        }
        return filmDTOS;
    }
}
