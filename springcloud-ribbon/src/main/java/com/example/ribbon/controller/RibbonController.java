package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhaojh
 * @date : 2019-12-11
 * @function :使用ribbon 作为微服务调用
 */

@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/userRibboin")
    public String userRibboin(){

        //使用restTemplate 调用远程服务
        String forObject = restTemplate.getForObject("http://SPRINGCLOUD-BANK1/bank1/transfer?myaccountNo=1&accountPassword=123456&otherAccountNo=2&amount=500", String.class);
        return "use ribbon is success";
    }
}
