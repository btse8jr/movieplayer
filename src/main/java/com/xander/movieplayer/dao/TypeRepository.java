package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.Type;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Xander on 2018-08-14.
 */
public interface TypeRepository extends CrudRepository<Type,Long> {
    Type findByTypeId(Long typeId);

    List<Type> findAll();

    @Transactional
    int deleteByTypeId(Long typeId);
}
