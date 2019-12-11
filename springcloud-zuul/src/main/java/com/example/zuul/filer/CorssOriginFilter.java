package com.example.zuul.filer;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : zhaojh
 * @date : 2019-12-11
 * @function :
 */
@Component
public class CorssOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器....");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * 实现步骤：
         * 1.将ServletResponse 对象转换成 HttpServletResponse对象
         * 2.通过HttpServletResponse 添加访问头信息
         */
        HttpServletResponse resp=(HttpServletResponse)response;
        resp.addHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            //判断请求方法  是否为 OPTIONS 如果是进行拦截，拒绝放问
            return;
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");

    }
}
