package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.Catlog;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Xander on 2018-08-13.
 */
public interface CatlogRepository extends CrudRepository<Catlog,Long> {
    Catlog findCatlogByCatlogId(Long catlogId);

    List<Catlog> findAll();

    @Transactional
    void deleteByCatlogId(Long catlogId);
}
