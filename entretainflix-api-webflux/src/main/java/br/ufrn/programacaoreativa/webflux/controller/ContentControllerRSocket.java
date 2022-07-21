package br.ufrn.programacaoreativa.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufrn.programacaoreativa.webflux.model.RSocketInput;
import br.ufrn.programacaoreativa.webflux.model.Usuario;
import br.ufrn.programacaoreativa.webflux.service.ContentService;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("contentrsocket")
public class ContentControllerRSocket {
	
	private final RSocketRequester rsocketRequester;
	
	public ContentControllerRSocket(RSocketRequester rSocketRequester) {
		this.rsocketRequester = rSocketRequester;
	}
	
	@GetMapping("/currentclient/{id}")
	public Mono<RSocketInput> currentUser(@PathVariable("id") Integer id){
		return rsocketRequester.route("request-response").data("{\"origin\": \"Client\", \"interaction\":\"Request\"}").retrieveMono(RSocketInput.class);
	}
	
}
