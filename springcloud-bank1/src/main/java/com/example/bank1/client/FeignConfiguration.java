package com.example.bank1.client;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhaojh
 * @date : 2019-09-29
 * @function :本配置类的作用：
 *  * 调用远程服务时候，遇到bug，比如接口调用失败，参数没有收到等等问题，或者想查看调用服务的性能，就需要配置Feign 的日志，
 */

@Configuration
public class FeignConfiguration {

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
