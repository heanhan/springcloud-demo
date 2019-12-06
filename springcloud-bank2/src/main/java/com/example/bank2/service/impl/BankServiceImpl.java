package com.example.bank2.service.impl;

import com.example.bank2.mapper.IBankMapper;
import com.example.bank2.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :
 */

@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private IBankMapper bankMapper;

    @Override
    @Transactional
    public void transfer(String accountNo,Double amount){
        bankMapper.updateAccountBalance(accountNo,amount);
    }
}
