package com.example.bank2.controller;

import com.example.bank2.service.IBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :
 */
@Slf4j
@RestController
@RequestMapping(value = "/bank2")
public class Bank2Controller {

    @Autowired
    private IBankService bankService;

    @GetMapping(value = "/transfer")
    public String transfer(String otherAccountNo,Double amount){
        log.info("开进进入转账的业务！ 转账的账户："+otherAccountNo+"  转账的金额："+amount);
        //进行转账操作
        bankService.transfer(otherAccountNo,amount);
        return "操作成功！";
    }
}
