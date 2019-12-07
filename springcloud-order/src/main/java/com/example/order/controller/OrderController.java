package com.example.order.controller;

import com.example.commons.utils.IdWorker;
import com.example.order.entity.pojo.Order;
import com.example.order.feignclient.StorageFeignClient;
import com.example.order.service.OrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private StorageFeignClient storageFeignClient;

    /**
     * 需求：用户进行订单的下单，进行减库存 和用户金额操作
     */


    /**
     * 添加订单  业务步骤如下
     * 1.判断当前用户是否登录，没有登录提示用户进行登录
     * 2.当前用户登录后，创建订单，先判断当前手抖有库存，没有库存提示用户无法下单，
     * 3.有库存的情况下，创建订单，库存进行减去操作，
     * 4.进行支付，判断当前登录的用户账户是都有余额，没有提示用户余额不足，提示用户进入用户充值的页面，进行充值，不充值，半小时内订单失效。
     * 5.余额充足的情况下，进行支付。
     * 6.交易完成
     */
    @PostMapping(value = "/addOrder")
    public String addOrder(Order order){
        //1.假设用户已经登陆
        order.setUserId(121930L);//从登陆的用户信息中获取用户的账号信息
        //2.创建订单前，先判断当前是否有库存
        Integer count = order.getCount();
        Long productId = order.getProductId();
        String s = storageFeignClient.buyProductResult(productId, count);


        order.setId(idWorker.nextId()+"");//添加定的id




        return null;

    }
}
