package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.FilmType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Xander on 2018-08-20.
 */
public interface FilmTypeRepository extends CrudRepository<FilmType, Long> {
    FilmType findByFilmTypeId(Long filmTypeId);

    @Query(value = "select * from film_type where type_id=?1 group by film_id desc", nativeQuery = true)
    List<FilmType> getByTypeId(Long TypeId);

}
