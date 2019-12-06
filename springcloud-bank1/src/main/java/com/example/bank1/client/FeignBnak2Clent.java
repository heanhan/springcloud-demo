package com.example.bank1.client;

import com.example.bank1.client.clientFallback.FeignBank2ClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function : feign 实现的远程调用的 bank2
 */

@FeignClient(value = "springcloud-bank2",configuration = FeignConfiguration.class,fallback = FeignBank2ClientFallback.class,path = "/bank2")
public interface FeignBnak2Clent {

    @GetMapping(value = "/transfer")
    String transfer(@RequestParam("otherAccountNo") String accountNo,@RequestParam("amount") Double amount);
}
