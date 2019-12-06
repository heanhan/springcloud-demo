package com.example.bank1.service;

public interface IBankService {

    /**
     * 更新 账户
     * @param myAccountNo  我方账户编号
     * @param accountPassword 交易密码
     * @param otherAccountNo 对方账户编号
     * @param amount 转账金额
     * @return int
     */
    void updateAccountBalance(String myAccountNo,String accountPassword,String otherAccountNo,Double amount);
}
