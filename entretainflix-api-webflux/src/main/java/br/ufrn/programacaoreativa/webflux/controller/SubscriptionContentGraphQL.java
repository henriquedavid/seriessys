package br.ufrn.programacaoreativa.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufrn.programacaoreativa.webflux.model.SubscriptionEmail;
import br.ufrn.programacaoreativa.webflux.model.SubscriptionInput;
import br.ufrn.programacaoreativa.webflux.service.SubscriptionEmailService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class works as a form to the user receive updates about new contents in their emails
 * @author henrique
 *
 */
@Controller
public class SubscriptionContentGraphQL {
	
	@Autowired
	private SubscriptionEmailService service;
	
	@QueryMapping("getAllSubscriptions")
	public Flux<SubscriptionEmail> getAllSubscriptions(){
		return service.getAllSubscriptionsEmail();
	}
	
	@QueryMapping("getUserSubscription")
	public Mono<SubscriptionEmail> getUserSubscription(@Argument Integer id){
		return service.getSubscriptionByID((long) id);
	}
	
	@MutationMapping("addUserInSubscription")
	public Mono<SubscriptionEmail> addUserInSubscription(@Argument Mono<SubscriptionInput> subsInput){
		return service.addSubscription(subsInput);
	}
	
	@MutationMapping("deleteUserInSubscription")
	public Mono<Void> deleteUserInSubscription(@Argument Integer id){
		return service.deleteSubscription((long) id);
	}

}
