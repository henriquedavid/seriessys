package br.ufrn.programacaoreativa.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableEurekaClient
@EnableWebFlux
public class EntretainflixWebfluxUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntretainflixWebfluxUserApplication.class, args);
	}

}
