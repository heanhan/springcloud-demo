package com.example.bank1.controller;

import com.example.bank1.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :
 */

@RestController
@RequestMapping(value = "/bank1")
public class Bank1Controller {

    @Autowired
    private IBankService bankService;

    /**
     * 张三转账
     * @param amount
     * @return
     */
    @GetMapping("/transfer")
    public String transfer(String myaccountNo, String accountPassword, String otherAccountNo,Double amount){
//        accountInfoService.updateAccountBalance("1",amount);
         bankService.updateAccountBalance(myaccountNo,accountPassword,otherAccountNo,amount);
        return "bank1"+amount;
    }
}
