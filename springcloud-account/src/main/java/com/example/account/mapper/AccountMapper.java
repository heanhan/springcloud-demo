package com.example.account.mapper;




import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2019-12-06
 * @function :
 */

public interface AccountMapper {

        /**
         * 扣减账户余额
         * @param userId 用户id
         * @param money 金额
         */
        void decrease(Long userId,  BigDecimal money);
    }

