package br.ufrn.programacaoreativa.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntretainflixGatewayApplication {
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) throws Exception {
		return builder.routes()
				.route(p -> p
						.path("/**")
						.filters(f -> f.rewritePath("/catalog/(?<path>.*)", "/${path}"))
						.uri("http://entretainflix:8080"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EntretainflixGatewayApplication.class, args);
	}

}
