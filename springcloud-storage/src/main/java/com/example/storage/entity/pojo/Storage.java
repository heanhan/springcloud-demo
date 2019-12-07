package com.example.storage.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Storage
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 库存实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id; //记录id

    private Long productId; //产品id

    private String productName; //产品名称

    private Integer total; //总库存

    private Integer used; //已用库存

    private Integer residue; //剩余库存
}
