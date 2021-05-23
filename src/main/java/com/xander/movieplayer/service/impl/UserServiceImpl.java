package com.xander.movieplayer.service.impl;

import com.xander.movieplayer.dao.UserRepository;
import com.xander.movieplayer.dto.UserDTO;
import com.xander.movieplayer.entity.User;
import com.xander.movieplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.xander.movieplayer.util.CheckUtil.*;
import static com.xander.movieplayer.util.MD5Util.*;
import static com.xander.movieplayer.util.StringUtil.*;


/**
 * Created by Xander on 2018-08-20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        check(isNotEmpty(username),"用户名不为空");
        check(isNotEmpty(password),"密码不为空");
        User user=userRepository.findUserByUsername(username);
        check(user!=null,"用户不存在");
        check(user.getPassword().equals(md5(password)),"用户名或密码错误");
        return user;
    }

    @Override
    public void register(UserDTO userDTO) {
        User user=new User();
        check(isNotEmpty(userDTO.getUsername())||isNotEmpty(userDTO.getPassword())||isNotEmpty(userDTO.getPassword2())||isNotEmpty(userDTO.getVerify()),"各项不能为空");
        check(userRepository.findUserByUsername(user.getUsername())==null,"用户已存在");
        check(userDTO.getPassword().equals(userDTO.getPassword2()),"两次密码不一致");
        check(userDTO.getVerify().toLowerCase().equals(userDTO.getVerCode().toLowerCase()),"验证码错误");
        check(userDTO.getPassword().length()>6,"密码过于简单");
        check(userDTO.getPassword().replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length()==0,"密码包含非法字符");
        user.setUsername(userDTO.getUsername());
        user.setPassword(md5(userDTO.getPassword()));
        user.setPermission(0);
        userRepository.save(user);
    }

    @Override
    public void exist(String username){
        check((userRepository.findUserByUsername(username))==null,"用户已存在");
    }
}
