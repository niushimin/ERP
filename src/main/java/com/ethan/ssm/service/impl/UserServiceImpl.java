package com.ethan.ssm.service.impl;

import com.ethan.ssm.mapper.UserMapper;
import com.ethan.ssm.pojo.User;
import com.ethan.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Ethan New
 * @Date: 2019/5/15 21:45
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.login(username, password);
        return user != null;
    }
}
