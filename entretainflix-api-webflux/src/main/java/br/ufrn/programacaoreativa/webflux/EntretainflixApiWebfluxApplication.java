package br.ufrn.programacaoreativa.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class EntretainflixApiWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntretainflixApiWebfluxApplication.class, args);
	}

}
