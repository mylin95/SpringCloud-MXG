
回顾：（2020年12月15日22:42:34）
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
- 
注意：
启动服务的顺序(eureka服务端 -> 服务提供方 -> 服务消费方)，如下：
 1.microservice-cloud-05-eureka-6001
 2.microservice-cloud-05-eureka-6002
 3.microservice-cloud-03-provider-product-8001
 4.microservice-cloud-06-provider-product-8002
 5.microservice-cloud-04-consumer-product-80
 5.microservice-cloud-07-consumer-product-feign