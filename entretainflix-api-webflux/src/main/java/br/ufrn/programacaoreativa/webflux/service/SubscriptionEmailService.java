package br.ufrn.programacaoreativa.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.model.SubscriptionEmail;
import br.ufrn.programacaoreativa.webflux.model.SubscriptionInput;
import br.ufrn.programacaoreativa.webflux.repository.SubscriptionEmailRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubscriptionEmailService {

	@Autowired
	private SubscriptionEmailRepository repository;
	
	public Flux<SubscriptionEmail> getAllSubscriptionsEmail(){
		return repository.findAll();
	}
	
	public Mono<SubscriptionEmail> getSubscriptionByID(Long id){
		return repository.findById(id);
	}
	
	public Mono<SubscriptionEmail> addSubscription(Mono<SubscriptionInput> subs){
		return repository.saveAll(subs.flatMap(item -> {
			return Mono.just(new SubscriptionEmail(item.getNome(), item.getEmail()));
		})).next();
	}
	
	public Mono<Void> deleteSubscription(Long id){
		return repository.deleteById(id);
	}
}
