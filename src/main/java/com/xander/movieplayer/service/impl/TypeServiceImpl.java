package com.xander.movieplayer.service.impl;

import com.xander.movieplayer.dao.TypeRepository;
import com.xander.movieplayer.entity.Type;
import com.xander.movieplayer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xander on 2018-08-24.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public Type findByTypeId(Long typeId) {
        return typeRepository.findByTypeId(typeId);
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
