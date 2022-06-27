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
