package com.xander.movieplayer.service;

import com.xander.movieplayer.entity.User;

/**
 * Created by Xander on 2018-08-20.
 */
public interface UserService {
    User login(String username,String password);

    void register(User user);

    void exist(String username);
}
