package com.example.user.service;

public interface UserService {

    /**
     * 登录名的唯一性校验
     * @param username
     * @return
     */
    Boolean uniqueCheckName(String username);
}
