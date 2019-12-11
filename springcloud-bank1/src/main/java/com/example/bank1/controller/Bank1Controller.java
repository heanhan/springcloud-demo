package com.example.bank1.controller;

import com.example.bank1.service.IBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "SpringCloud-Bank1 ", description = "XXX银行Bank1", tags = { "springcloud-bank1框架的结合swagger接口文档使用 tags" })
public class Bank1Controller {

    @Autowired
    private IBankService bankService;

    /**
     * 张三转账
     * @param
     * @return
     */
    @GetMapping("/transfer")
    @ApiOperation(value = "从bank1转账到bank2", notes = "功能模块-转账")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(paramType = "query",name = "myaccountNo",value = "我的账号",dataType = "String"),
                    @ApiImplicitParam(paramType = "query",name = "accountPassword",value = "密码",dataType = "String"),
                    @ApiImplicitParam(paramType = "query",name = "otherAccountNo",value = "对方账户",dataType = "String"),
                    @ApiImplicitParam(paramType = "query",name = "amount",value = "转账金额",dataType = "Double")
            }
    )
    public String transfer(String myaccountNo, String accountPassword, String otherAccountNo,Double amount){
//        accountInfoService.updateAccountBalance("1",amount);
         bankService.updateAccountBalance(myaccountNo,accountPassword,otherAccountNo,amount);
        return "bank1"+amount;
    }
}
