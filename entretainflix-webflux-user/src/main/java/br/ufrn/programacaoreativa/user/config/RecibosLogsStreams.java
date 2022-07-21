package br.ufrn.programacaoreativa.user.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecibosLogsStreams {
	
	@Bean
	public Consumer<String> logtoken()
	{
		return val -> System.out.println("Log de recibo:" + val.toString());
	}

}
