package br.ufrn.programacaoreativa.webflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.config.RabbitMQConfig;
import br.ufrn.programacaoreativa.webflux.model.Content;
import br.ufrn.programacaoreativa.webflux.model.MensagemDTO;
import br.ufrn.programacaoreativa.webflux.repository.ContentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContentService {
	
	@Autowired
	private ContentRepository repository;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private RabbitTemplate template;
	
	public Flux<Content> getAllContent(){
		return repository.findAll();
	}
	
	public Mono<Content> getContentById(Long id) {
		return repository.findById(id);
	}
	
	public Mono<Content> addContent(Mono<Content> content) {
		return repository.saveAll(content).next().doOnNext(item -> {
			kafkaTemplate.send("newcontentpublish", "New content: " + item.getName());
		});
	}
	
	public Mono<Boolean> sendNotificationFromContent(Mono<MensagemDTO> message){
		return message.flatMap(item -> {
			template.convertAndSend(
					RabbitMQConfig.EXCHANGE, 
					RabbitMQConfig.ROUTING_KEY, 
					item.getIdcontent() + ": " + item.getMensagem());
			return Mono.just(true);
		});
	}
	
	public Mono<Content> updateContent(Mono<Content> content) {
		return repository.saveAll(content).next();
	}
	
	public Mono<Void> deleteContent(Long contentId) {
		return repository.deleteById(contentId);
	}

}
