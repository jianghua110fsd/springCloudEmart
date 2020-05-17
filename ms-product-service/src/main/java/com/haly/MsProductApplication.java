package com.haly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class MsProductApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MsProductApplication.class, args);
	}

}
