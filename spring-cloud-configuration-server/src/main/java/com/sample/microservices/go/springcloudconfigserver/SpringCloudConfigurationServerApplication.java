package com.sample.microservices.go.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigurationServerApplication.class, args);
	}

}
