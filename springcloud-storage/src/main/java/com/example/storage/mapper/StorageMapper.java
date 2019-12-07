package com.example.storage.mapper;

import com.example.storage.entity.pojo.Storage;

public interface StorageMapper {

    /**
     * 查询当前的商品的库存数量是否满足购买需求
     * @param productId 产品id
     * @param count 购买数量
     * @return  大于0 满足，小于 不满足
     */
    Integer findStorageCountByidAndCount(Long productId, Integer count);

    /**
     * 对商品进行购买
     * @param productId 产品id
     * @param count 购买数量
     * @return  购买结果
     */
    int buyProductRestult(Long productId, Integer count);
}
