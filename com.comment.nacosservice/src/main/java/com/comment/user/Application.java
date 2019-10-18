package com.comment.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//启动类中增加 @EnableDiscoveryClient 注解，声明这是一个 Eureka Client。服务提供者
@EnableDiscoveryClient 
//因为工程中没有关于dataSource相关的配置信息，当spring创建dataSource bean因缺少相关的信息就会报错
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.comment.user.dao")
//@SpringBootApplication(scanBasePackages="com.comment.user.dao")

@SpringBootApplication
@ComponentScan(basePackages = {"com.comment.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

