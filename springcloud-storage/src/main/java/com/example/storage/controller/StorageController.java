package com.example.storage.controller;

import com.example.commons.utils.IdWorker;
import com.example.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StorageController
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 库存的控制器
 */

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private StorageService storageService;

    /**
     * 根据产品的id和数量查询当前的库存是否充足
     * @param productId  产品id
     * @param count 购买的数量
     * @return
     */
    @PostMapping(value = "/findStorageCountByidAndCount")
    public String  findStorageCountByidAndCount(String productId,String count){
        Integer storageCountByidAndCount = storageService.findStorageCountByidAndCount(Long.parseLong(productId), Integer.parseInt(count));
        if(storageCountByidAndCount>0){
            return "true";
        }
        return "false";

    }

    /**
     * 购买产品
     * @param productId  产品id
     * @param count 购买的数量
     * @return 购买结果
     */
@PostMapping(value = "/buyProductResult")
    public String buyProductResult(String productId,String count){
        String buyProductRestult = storageService.buyProductRestult(Long.parseLong(productId), Integer.parseInt(count));
        return buyProductRestult;
    }
}
