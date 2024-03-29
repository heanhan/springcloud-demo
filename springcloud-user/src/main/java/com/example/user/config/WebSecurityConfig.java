package com.example.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: WebSecurityConfig
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 安全配置类
 * 添加Spring security 的依赖后，所欲偶的访问都会被拦截，只是使用了该spring security 的加密加盐的部分
 * 所有需要放开所有的的请求，是的可以匿名访问
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
