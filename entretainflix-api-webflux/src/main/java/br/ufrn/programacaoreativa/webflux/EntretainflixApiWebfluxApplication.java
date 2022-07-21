package br.ufrn.programacaoreativa.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableWebFlux
@EnableEurekaClient
public class EntretainflixApiWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntretainflixApiWebfluxApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("newcontentpublish", "Teste");
		};
	}
	
	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
