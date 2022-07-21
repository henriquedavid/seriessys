package br.ufrn.programacaoreativa.user.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.user.model.LocalizationData;
import br.ufrn.programacaoreativa.user.model.RSocketInput;
import br.ufrn.programacaoreativa.user.model.Usuario;
import br.ufrn.programacaoreativa.user.service.UsuarioService;
import reactor.core.publisher.Mono;

@Controller
public class LocalizationController {
	
	UsuarioService service;

	@MessageMapping("request-response")
	public Mono<RSocketInput> requestResponse(RSocketInput input){
		return Mono.just(new RSocketInput("http://localhost:7000", "Response example"));
	}
}
