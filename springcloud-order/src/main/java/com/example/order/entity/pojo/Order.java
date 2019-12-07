package com.example.order.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName: Order
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 订单
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

}
