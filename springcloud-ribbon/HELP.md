### Ribbon 的使用

在微服务中，业务都会被拆分成一个独立的系统，服务与服务的通讯是基于http restful的。Spring Cloud 有两种微服务调用方式，一种是ribbon+restTemplate
,另一种是feign 本微服务使用ribbon+RestTemplate方式实现。

一、Ribbon的简介
        
        ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。
        
        ribbon 已经默认实现了这些配置bean：
        
        IClientConfig ribbonClientConfig: DefaultClientConfigImpl
        
        IRule ribbonRule: ZoneAvoidanceRule
        
        IPing ribbonPing: NoOpPing
        
        ServerList ribbonServerList: ConfigurationBasedServerList
        
        ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter
        
        ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
        
二、使用方式
    
    注，本模块的微服务在main类上使用@SpringCloudApplication注解，因为该注解实际包含以下注解
    @SpringBootApplication
    @EnableDiscoveryClient
    @EnableCircuitBreaker
    所以需要添加eureka 、hystrix的坐标，不然会报错。
    
            <!--eureka的client依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
            </dependency>
    
            <!--使用熔断器  因为在main主类上添加了SpringCloudApplication注解，默认需要集成熔断器-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
            </dependency>
            
            
    在工程的启动类中,通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate;
    并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }
        
        使用通过此前注入的RestTemplate进行调用
        在这里我们直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        
        
        @GetMapping(value = "/userRibboin")
        public String userRibboin(){
    
            //使用restTemplate 调用远程服务
            String forObject = restTemplate.getForObject("http://SPRINGCLOUD-BANK1/bank1/transfer?myaccountNo=1&accountPassword=123456&otherAccountNo=2&amount=500", String.class);
            return "use ribbon is success";
        }
        
        
        