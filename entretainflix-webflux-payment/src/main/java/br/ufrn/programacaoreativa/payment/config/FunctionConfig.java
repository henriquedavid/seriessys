package br.ufrn.programacaoreativa.payment.config;

import java.time.LocalDateTime;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ufrn.programacaoreativa.payment.model.ReciboDTO;

@Configuration
public class FunctionConfig {

	@Bean
	public Supplier<ReciboDTO> calculatenumberofepisodes(){
		return () -> new ReciboDTO(0, 0.0, LocalDateTime.now());
	}
}
