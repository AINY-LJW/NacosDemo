package com.comment.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comment.test.feginclient.RemoteClient;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	@Autowired
//    private RemoteClient remoteClient;
//
//    @GetMapping("/feign")
//    public String test() {
//        return remoteClient.helloNacos();
//    }
//    
//    @GetMapping("/haha")
//    public String haha() {
//        return "hahahahahahahaha";
//    }

}
