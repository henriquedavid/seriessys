package br.ufrn.programacaoreativa.webflux.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import br.ufrn.programacaoreativa.webflux.model.Cobranca;
import br.ufrn.programacaoreativa.webflux.model.Episode;
import br.ufrn.programacaoreativa.webflux.model.EpisodesDTO;
import br.ufrn.programacaoreativa.webflux.model.User;
import br.ufrn.programacaoreativa.webflux.repository.EpisodeRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@Service
public class EpisodeService {
	
	@Autowired
	private EpisodeRepository repository;
	
	@Autowired
	private ReactorLoadBalancerExchangeFilterFunction lbFunction;
	
	public Flux<Episode> getAllEpisodes(){
		return repository.findAll();
	}
	
	public Mono<Episode> getEpisodeById(Long id) {
		return repository.findById(id);
	}
	
	public Mono<Episode> buildFallbackPayEpisode(Throwable t){
		return Mono.just(new Episode());
	}
	
	public Mono<Episode> retryFallbackPayEpisode(Throwable t){
		return Mono.just(new Episode((long)-1, "Retrying to pay episode", (long) 0, (long) 1));
	}
	
	@CircuitBreaker(name="payepisodeservice", fallbackMethod="buildFallbackPayEpisode")
	@Retry(name="retrypayepisodeservice", fallbackMethod = "retryFallbackPayEpisode")
	@Bulkhead(name="bulkheadpayepisodeservice", type = Bulkhead.Type.SEMAPHORE, fallbackMethod="buildFallbackPayEpisode")
	public Mono<Episode> payEpisode(Long idUser, Long idEpisode) {
		
		Mono<User> responseSec = WebClient.builder()
				.baseUrl("http://entretainflixuserwebflux")
				.filter(lbFunction)
				.build()
				.get()
				.uri("/user/"+idUser)
				.retrieve()
				.bodyToMono(User.class);
		
		System.out.println("PASSOU aqui");
		
		Mono<Cobranca> responseSec2 = WebClient.builder()
				.baseUrl("http://entretainflixpagamentowebflux")
				.filter(lbFunction)
				.build()
				.post()
				.uri("/cobranca")
				.header("content-type", "application/json")
				.bodyValue("{\"userId\": " + idUser + ", \"episodeId\" : " + idEpisode + " , \"valor\" : " + 3.25 + "}")
				.retrieve()
				.bodyToMono(Cobranca.class);
		
		Mono<Episode> entrada = Mono.zip(responseSec, responseSec2)
				.flatMap(tuples -> {
					return getEpisodeById(idEpisode);
				});

		return entrada;
	}
	
	public Mono<User> buildFallbackUserThatBoughtEpisodes(Throwable tw){
		return Mono.just(new User());
	}
	
	
	public Mono<User> retryFallbackUserThatBoughtEpisodes(Throwable tw){
		return Mono.just(new User(-1, "Retring to send", "", ""));
	}
	
	
	@CircuitBreaker(name="getuserthatboughtepisodesservice", fallbackMethod="buildFallbackUserThatBoughtEpisodes")
	@Retry(name="retryuserthatboughtepisodes", fallbackMethod = "retryFallbackUserThatBoughtEpisodes")
	@Bulkhead(name="bulkheaduserthatboughtepisodes", type = Bulkhead.Type.SEMAPHORE, fallbackMethod="buildFallbackUserThatBoughtEpisodes")
	public Mono<User> getUserThatBoughtEpisodes(Long idUser){
		Mono<User> responseSec = WebClient.builder()
				.baseUrl("http://entretainflixuserwebflux")
				.filter(lbFunction)
				.build()
				.get()
				.uri("/user/"+idUser)
				.retrieve()
				.bodyToMono(User.class);
		
		return responseSec;
	}
	
	public Mono<String> buildFallbackEpisodesBought(Throwable tw){
		return Mono.just("Error while loading requisition");
	}
	
	public Mono<String> retryFallbackEpisodesBought(Throwable tw) {
		return Mono.just("Retrying to reload");
	}
	
	@CircuitBreaker(name="getepisodesboughtservice", fallbackMethod="buildFallbackEpisodesBought")
	@Retry(name="retryepisodesbought", fallbackMethod = "retryFallbackEpisodesBought")
	@Bulkhead(name="bulkheadgetepisodesbought", type = Bulkhead.Type.SEMAPHORE, fallbackMethod="buildFallbackEpisodesBought")
	public Mono<String> getMyEpisodesBought(Long idUser) {

		Mono<String> responseSpec = WebClient.builder()
				.baseUrl("http://entretainflixpagamentowebflux")
				.filter(lbFunction)
				.build()
				.get()
				.uri("/cobranca/user/"+idUser)
				.retrieve()
				.bodyToMono(String.class);
		return responseSpec;
		
	}
	
	public Mono<Episode> createEpisode(Mono<Episode> episode) {
		return repository.saveAll(episode).next();
	}
	
	public Mono<Episode> updateEpisode(Mono<Episode> episode) {
		return repository.saveAll(episode).next();
	}
	
	public Mono<Void> deleteEpisode(Long episodeId) {
		return repository.deleteById(episodeId);
	}

}
