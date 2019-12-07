package com.example.order.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName: StorageFeignClient
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 使用feign 库存微服务信息
 */
@FeignClient(value = "springcloud-storage",configuration = StorageFeignConfiguration.class,fallback = "",path = "/storage")
public interface StorageFeignClient {

    /**
     * 购买产品
     * @param productId  产品id
     * @param count 购买的数量
     * @return 购买结果
     */
    @PostMapping(value = "/buyProductResult")
    String buyProductResult(Long productId,Integer count);


}
