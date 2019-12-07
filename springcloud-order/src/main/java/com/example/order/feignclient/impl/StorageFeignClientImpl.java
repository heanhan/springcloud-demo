package com.example.order.feignclient.impl;

import com.example.order.feignclient.StorageFeignClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName: StorageFeignClientImpl
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 熔断的结果
 */
@Component
public class StorageFeignClientImpl implements StorageFeignClient {
    @Override
    public String buyProductResult(Long productId, Integer count) {
        return "fallback";
    }
}
