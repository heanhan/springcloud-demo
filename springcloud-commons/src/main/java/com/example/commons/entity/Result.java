package com.example.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Result
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: springboot 统一消息返回体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean flag;//请求响应标识  success /false
    private Integer code;// 请求响应编码
    private String message;//响应消息
    private Object data;//返回数据


    /**
     * 无数据返回构造
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

}