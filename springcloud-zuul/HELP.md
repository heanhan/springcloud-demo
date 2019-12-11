# Getting Started
### zuul 的使用
    
    一、介绍
    Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
    
    使用
    添加pom
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
            </dependency>
            
    在其入口applicaton类加上注解@EnableZuulProxy，开启zuul的功能：
    
    然后在application.yml 或者application.properties中配置
    yml 方式：
    zuul:
      routes:
        api-a:
          path: /api-a/**
          serviceId: springcloud-ribbon
          
    properties方式：
    
    #ribbon
    zuul.routes.api-c.path=/api-c/**
    zuul.routes.api-c.service-id=springcloud-ribbon

   服务过滤（zuul实际上就是一个过滤器，对资源进行过滤）
   自定义一个类继承ZuulFilter类重写里面的方法如下：
   
                @Override
                public String filterType() {
                    return "pre";
                }
            
                @Override
                public int filterOrder() {
                    return 0;
                }
            
                @Override
                public boolean shouldFilter() {
                    return true;
                }
            
                @Override
                public Object run() {
                    RequestContext ctx = RequestContext.getCurrentContext();
                    HttpServletRequest request = ctx.getRequest();
                    //这里是具体的自定义的逻辑代码
                    return null;
                }
                
                解释：
                filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
                pre：路由之前
                routing：路由之时
                post： 路由之后
                error：发送错误调用
                filterOrder：过滤的顺序
                shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
                run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
                
                
                
                
   额外： 统一做跨域的请求访问处理（具体代码见项目中的filet包下的CorssOriginFiler类）
   
