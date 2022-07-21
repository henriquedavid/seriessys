package br.ufrn.programacaoreativa.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableEurekaClient
public class EntretainflixWebfluxPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntretainflixWebfluxPaymentApplication.class, args);
	}

}
