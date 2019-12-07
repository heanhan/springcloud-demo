package com.example.account.entity.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaojh0912
 * desc:账户的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;//id //账户id

    private Long userId; //用户id

    private BigDecimal total; //总额度

    private BigDecimal used;//已经消费的金额

    private BigDecimal residue;//剩余金额
}
