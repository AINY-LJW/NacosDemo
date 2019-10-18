package com.comment.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


//去掉了之前使用RestTemplate 和负载均衡相关的配置，因为Feign已经做了整合。
@EnableFeignClients
@EnableDiscoveryClient
//监控
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.comment.*"})
@SpringBootApplication
public class Application {
	/**
	 * 我们通常使用RestTemplate调用其他服务的API
	 * 文件中实例化一个RestTemplate，这样其他类中可以用@Autowired获得到RestTemplate对象。
	 * 这里用到了@Bean注解，作用是实例化一个Bean并使用该方法的名称命名。
	 * @return RestTemplate
	 */
//	@Bean
//	// Ribbon开启均衡负载能力。使用了 Ribbon 后调用服务端变得很简单， RestTemplate 甚至可以直接通过服务注册名称去调用API，这是利用Ribbon后开启了虚拟主机的能力。
//	 @LoadBalanced 
//	 public RestTemplate restTemplate() {
//	    return new RestTemplate();
//	 }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

