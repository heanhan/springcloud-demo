package com.example.bank1.service.impl;

import com.example.bank1.client.FeignBnak2Clent;
import com.example.bank1.mapper.IBankMapper;
import com.example.bank1.service.IBankService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :
 */
@Slf4j
@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private IBankMapper bankMapper;

    @Autowired
    private FeignBnak2Clent feignBnak2Clent;

    @Override
    @Transactional//开启本地事务
    @GlobalTransactional//开启全局事务
    public void updateAccountBalance(String myaccountNo, String accountPassword, String otherAccountNo,Double amount) {
        log.info("分布式事务的开始！"+ RootContext.getXID()+"为全局事务的XID");
        //从bank1 的数据库中进行操作转账
        int i = bankMapper.updateAccountBalance(myaccountNo, accountPassword, amount);
        //开始调用 对bank2 账户进行转账
        String transfer = feignBnak2Clent.transfer(otherAccountNo, amount);
        //远程调用失败
        if(transfer.equals("fallback")){
            throw new RuntimeException("bank1 调用bank2 服务异常");
        }
        //人为制造错误
//        if(amount==3){
//            throw new RuntimeException("bank1 make exception  3");
//        }
    }
}
