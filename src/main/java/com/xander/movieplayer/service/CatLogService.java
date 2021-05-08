package com.xander.movieplayer.service;

import com.xander.movieplayer.entity.Catlog;

import java.util.List;

/**
 * Created by Xander on 2018-08-20.
 */
public interface CatLogService {
    Catlog findByCatlogId(Long catlogId);

    List<Catlog> findAll();
}
