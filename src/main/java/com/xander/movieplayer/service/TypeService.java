package com.xander.movieplayer.service;

import com.xander.movieplayer.entity.Type;

import java.util.List;

/**
 * Created by Xander on 2018-08-20.
 */
public interface TypeService {
    Type findByTypeId(Long typeId);

    List<Type> findAll();
}
