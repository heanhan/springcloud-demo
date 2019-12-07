package com.example.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderController
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 订单控制器
 */

@RestController
@RequestMapping(value = "order")
public class OrderController {

    /**
     * 需求：用户进行订单的下单，进行减库存 和用户金额操作
     */


    /**
     * 添加订单
     * @return
     */
    @PostMapping(value = "/addOrder")
    public String addOrder(){


        return null;

    }
}
