package br.ufrn.programacaoreativa.config;

import java.security.SecureRandom;
import java.util.function.Function;

import javax.crypto.Cipher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ufrn.programacaoreativa.config.models.ReciboDTO;
import reactor.core.publisher.Flux;

@Configuration
public class FunctionConfiguration {
	
	@Bean
	public Function<Flux<ReciboDTO>, Flux<String>> criptografartoken(){
		return flux -> flux.map(value -> {
			return "Valor recebido de " + value.getValor() + " do Usuário " + value.getIdUser();
		});
	}

}
