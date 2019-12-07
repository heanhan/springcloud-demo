package com.example.user.controller;

import com.example.commons.entity.Result;
import com.example.commons.entity.StatusCode;
import com.example.commons.utils.IdWorker;
import com.example.user.entity.pojo.User;
import com.example.user.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 用户控制器
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    /**
     * 用户的信息的唯一性校验
     * @param userName 用户名 可以是手机号也可以是字符串变量
     * @return  用户名可用返回true ,用户名不唯一返回false
     */
    @PostMapping(value = "/uniqueCheckName")
    public Boolean uniqueCheckName(@RequestParam(required = false) String userName){
        if(userName!=null&&! "".equals(userName)){
            Boolean aBoolean = userService.uniqueCheckName(userName);
            return aBoolean;
        }
        return false;
    }

    /**
     * 用户的注册
     * @param user
     * @return
     */
    @PostMapping(value = "/registerUser")
    public Result registerUser(User user){

        return new Result(true, StatusCode.OK,"添加成功！");
    }


}


