package com.example.storage.service.impl;

import com.example.storage.entity.pojo.Storage;
import com.example.storage.mapper.StorageMapper;
import com.example.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StorageServiceImpl
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: TOO
 */

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    /**
     * 查询当前的商品的库存数量是否满足购买需求
     * @param productId 产品id
     * @param count 购买数量
     * @return  大于0 满足，小于 不满足
     */
    @Override
    public Integer findStorageCountByidAndCount(Long productId,Integer count){
        Integer result =storageMapper.findStorageCountByidAndCount(productId,count);
        return result;
    }

    /**
     * 对商品进行购买
     * @param productId 产品id
     * @param count 购买数量
     * @return  购买结果
     */
    @Override
    public String buyProductRestult(Long productId,Integer count){
        int result=-1;
        //先判断库存是否充足
        Integer storageCountByidAndCount = this.findStorageCountByidAndCount(productId, count);
        if(storageCountByidAndCount>0){
            result= storageMapper.buyProductRestult(productId,count);
            if(result>0){
                return "buy success";
            }
        }
        return "buy fail";
    }
}
