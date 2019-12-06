package com.example.bank2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBankMapper {

    /**
     * 更新 账户
     * @param otherAccountNo 转账的账户编号
     * @param amount 转账金额
     * @return int
     */
    void updateAccountBalance(String otherAccountNo,Double amount);
}
