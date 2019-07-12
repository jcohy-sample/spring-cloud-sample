package com.jcohy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
public class AccountProvider19996 {
	public static void main(String[] args)
	{
		SpringApplication.run(AccountProvider19996.class, args);
	}
}
