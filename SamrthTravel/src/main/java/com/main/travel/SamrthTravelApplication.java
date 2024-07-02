package com.main.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SamrthTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamrthTravelApplication.class, args);
	}

}
