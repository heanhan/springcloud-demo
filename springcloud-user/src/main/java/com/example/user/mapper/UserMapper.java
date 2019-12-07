package com.example.user.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 用户名的唯一性校验
     * @param username 用户名
     * @return
     */
    int uniqueCheckName(String username);
}
