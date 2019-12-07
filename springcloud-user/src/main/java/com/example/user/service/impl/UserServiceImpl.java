package com.example.user.service.impl;

import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: TOO
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录名的唯一性校验
     * @param username
     * @return
     */
    @Override
    public Boolean uniqueCheckName(String username){
        int i = userMapper.uniqueCheckName(username);
        if (i<=0){
            return true;
        }
        return false;
    }
}
