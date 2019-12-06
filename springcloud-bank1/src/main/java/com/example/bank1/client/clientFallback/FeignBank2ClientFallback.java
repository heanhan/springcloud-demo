package com.example.bank1.client.clientFallback;

import com.example.bank1.client.FeignBnak2Clent;
import org.springframework.stereotype.Component;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :
 */

@Component
public class FeignBank2ClientFallback implements FeignBnak2Clent {
    @Override
    public String transfer(String accountNo, Double amount) {
        return "fallback";
    }
}
