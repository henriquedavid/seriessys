package br.ufrn.programacaoreativa.webflux.controller;

import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.webflux.model.Content;
import br.ufrn.programacaoreativa.webflux.model.MensagemDTO;
import br.ufrn.programacaoreativa.webflux.model.User;
import br.ufrn.programacaoreativa.webflux.model.Usuario;
import br.ufrn.programacaoreativa.webflux.repository.ContentRepository;
import br.ufrn.programacaoreativa.webflux.service.ContentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	ContentService service;
	
	private final RSocketRequester rsocketRequester;
	
	public ContentController(RSocketRequester rsocketRequester) {
		this.rsocketRequester = rsocketRequester;
	}

	@GetMapping
	public Flux<Content> getAllContent(){
		return service.getAllContent();
	}
	
	@GetMapping("/{id}")
	public Mono<Content> getContentById(@PathVariable("id") Long id){
		return service.getContentById(id);
	}
	
	@PostMapping
	public Mono<Content> createContent(@RequestBody Mono<Content> content){
		return service.addContent(content);
	}
	
	@PostMapping("/notification/{idcontent}")
	public Mono<Boolean> sendNotificationFromContent(@RequestBody Mono<MensagemDTO> message){
		return service.sendNotificationFromContent(message);
	}
	
	@PutMapping
	public Mono<Content> updateContent(@RequestBody Mono<Content> content){
		return  service.updateContent(content);
	}
	
//	@GetMapping("/currentclient/{id}")
//	public Mono<Usuario> currentUser(@PathVariable("id") Integer id){
//		return rsocketRequester.route("localization/actualuser").data(id).retrieveMono(Usuario.class);
//	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteContent(@PathVariable("id") Long contentId){
		return service.deleteContent(contentId);
	}

}
