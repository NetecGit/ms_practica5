package com.netec.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroCarritoFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCarritoFeignApplication.class, args);
	}

}
