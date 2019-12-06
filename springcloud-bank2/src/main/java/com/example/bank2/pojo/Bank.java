package com.example.bank2.pojo;

import lombok.Data;

/**
 * @author : zhaojh
 * @date : 2019-09-28
 * @function :
 */

@Data
public class Bank {

    private Long id; //主键id
    private String accountName;  //银行的账户
    private String accountNo; //银行开户账号
    private String accountPassword;//交易密码
    private Double accountBalance;//账号金额
}
