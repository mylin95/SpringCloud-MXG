
## 回顾：（2020年12月15日22:42:34）
- microservice-cloud-01模块：用于声明依赖以及版本，后续模块不需要添加版本信息
- microservice-cloud-02-api模块：用于声明公用模块的实体类
- microservice-cloud-03-provider-product-8001模块：是服务的提供者，eureka服务的提供方
（注意：本项目原本是通过ip访问的；改造成eureka服务后，必须先开启服务05）
- microservice-cloud-04-consumer-product-80模块：是服务的消费者，eureka服务的消费方
- microservice-cloud-05-eureka-6001模块：是eureka的服务端，给模块提供注册的服务
- microservice-cloud-05-eureka-6002模块：是eureka的服务端，给模块提供注册的服务（和上一个服务一起，搭建eureka注册中心的集群，注意配置信息）
- microservice-cloud-06-provider-product-8002模块：也是eureka的服务端，同03项目一个服务名，实现负载均衡测试
- microservice-cloud-07-consumer-product-feign模块：是服务的消费者，eureka服务的消费方。
是microservice-cloud-04-consumer-product-80项目的升级版；同样也是用80端口，因此两者不能同时运行。
不同的是，此项目使用Feign的方式调用服务间的接口。

注意：
启动服务的顺序(eureka服务端 -> 服务提供方 -> 服务消费方)，如下：
 1.microservice-cloud-05-eureka-6001
 2.microservice-cloud-05-eureka-6002
 3.microservice-cloud-03-provider-product-8001
 4.microservice-cloud-06-provider-product-8002
 5.microservice-cloud-04-consumer-product-80
 5.microservice-cloud-07-consumer-product-feign
 
 
 ## 2021年2月21日15:41:45：使用SpringCloud Config配置中心
 
 ### microservice-cloud-11-config-server-5001模块：SpringCloud Config配置中心服务端
 
- pom文件添加配置中心的依赖
- springboot的启动来添加注解（@EnableConfigServer: 开启配置中心功能）
- application.yml文件添加配置中心的配置信息

### microservice-cloud-12-config-client-8080: SpringCloud Config配置中心客户端小例子
- pom文件添加配置中心的依赖
- bootstrap.yml文件中配置必要的配置中心信息

### microservice-cloud-13-eureka-config-6001模块: 整合Config配置中心的Eureka服务端
- 整合Eureka配置、整合配置中心的配置（bootstrap.yml）

### microservice-cloud-14-product-config-8001模块：Eureka客户端整合Config配置中心的 Product生产者 && 整合消息总线组件Bus
- 整合Eureka配置、整合配置中心的配置（bootstrap.yml）
- 参考microservice-cloud-03-provider-product模块，构建项目
- 消息总线：1.修改配置中心的配置后，不需要重启项目，**只需要刷新配置**: 通过POST请求[URL](http://localhost:8001/actuator/bus-refresh/)
- 消息总线的配置自动刷新-**属性变量**：1.需要在实体类上方加上注解@RefreshScope 2.访问POST请求[URL](http://localhost:8001/actuator/bus-refresh/)
- 消息总线的配置自动刷新-**普通数据源**：直接修改spring.datasource中的配置就可以生效，不需要额外配置
- 消息总线的配置自动刷新-**druid数据源**：1.需要配置数据源配置类，见DruidConfig.java 2.添加配置后，修改spring.datasource中的配置才可以生效



  