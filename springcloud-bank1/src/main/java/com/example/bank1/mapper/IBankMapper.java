package com.example.bank1.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBankMapper {
    /**
     * 更新 账户
     * @param accountNo  账户编号
     * @param accountPassword 交易密码
     * @param amount 金额
     * @return int
     */
    int updateAccountBalance(String accountNo,String accountPassword,Double amount);
}
