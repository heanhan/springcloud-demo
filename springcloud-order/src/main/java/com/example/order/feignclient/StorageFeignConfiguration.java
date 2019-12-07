package com.example.order.feignclient;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: StorageFeignConfiguration
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: TOO
 */
@Component
public class StorageFeignConfiguration {

    /**
     * 日志等级有四种
     * NONE ：不输出日志
     * BASIC :只输出请求方法的URL和响应的状态码以及接口执行的时间
     * HEADERS :将BASIC信息和请求头信息输出
     * FULL : 输出完整的请求信息
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


    /**
     * 配置Basic认证
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }

    /**
     * 配置超时时间
     * options(param1,param2)
     * 参数一：是连接超时时间（ms），默认值是 10*10000
     * 参数二：是取超时时间（ms）默认值为 60*1000
     * @return
     */
    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
}
