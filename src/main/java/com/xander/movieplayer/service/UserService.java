package com.xander.movieplayer.service;

import com.xander.movieplayer.dto.UserDTO;
import com.xander.movieplayer.entity.User;

/**
 * Created by Xander on 2018-08-20.
 */
public interface UserService {
    User login(String username,String password);

    void register(UserDTO userDTO);

    void exist(String username);
}
