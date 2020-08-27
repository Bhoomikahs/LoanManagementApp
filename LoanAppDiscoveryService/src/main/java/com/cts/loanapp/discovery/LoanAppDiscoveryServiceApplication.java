package com.cts.loanapp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoanAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAppDiscoveryServiceApplication.class, args);
	}

}
