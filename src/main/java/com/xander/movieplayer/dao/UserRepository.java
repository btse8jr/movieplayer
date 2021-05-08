package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Xander on 2018-08-13.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserByUserId(Long userId);

    @Transactional
    int deleteByUserId(Long userId);

}
