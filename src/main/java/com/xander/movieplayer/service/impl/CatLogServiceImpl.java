package com.xander.movieplayer.service.impl;

import com.xander.movieplayer.dao.CatlogRepository;
import com.xander.movieplayer.entity.Catlog;
import com.xander.movieplayer.service.CatLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xander on 2018-08-24.
 */
@Service
public class CatLogServiceImpl implements CatLogService {
    @Autowired
    private CatlogRepository catlogRepository;

    @Override
    public Catlog findByCatlogId(Long catlogId) {
        return catlogRepository.findCatlogByCatlogId(catlogId);
    }

    @Override
    public List<Catlog> findAll() {
        return catlogRepository.findAll();
    }
}
