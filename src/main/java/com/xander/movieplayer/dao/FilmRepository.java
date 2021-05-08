package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.Film;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Xander on 2018-08-14.
 */
public interface FilmRepository extends CrudRepository<Film, Long> {
    Film findByFilmId(Long filmId);

    List<Film> findAll(Sort sort);

    @Query(value = "select * from film group by film_id desc limit ?1", nativeQuery = true)
    List<Film> findByLimit(int length);

    @Query(value = "select * from film where catlog_id=?1", nativeQuery = true)
    List<Film> findByCatlogId(Long catLogId);

    @Transactional
    int deleteByFilmId(Long filmId);
}
