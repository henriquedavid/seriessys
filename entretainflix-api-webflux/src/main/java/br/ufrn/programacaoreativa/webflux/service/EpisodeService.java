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
	
	public Flux<Episode> getAllEpisodes(){
		return repository.findAll();
	}
	
	public Mono<Episode> getEpisodeById(Long id) {
		return repository.findById(id);
	}
	
	public Mono<Episode> payEpisode(Long idUser, Long idEpisode) {
		
		WebClient client = WebClient.create();
		Mono<User> responseSec = client.get()
				.uri("http://localhost:8082/user/"+idUser)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(User.class);

		
		
		
		WebClient client2 = WebClient.create();
		Mono<Cobranca> responseSec2 = client.post()
				.uri("http://localhost:8083/cobranca")
				.header("content-type", "application/json")
//				.accept(MediaType.APPLICATION_JSON)
				.bodyValue("{\"userId\": " + idUser + ", \"episodeId\" : " + idEpisode + " , \"valor\" : " + 3.25 + "}")
				.retrieve()
				.bodyToMono(Cobranca.class);
		
		Mono<Episode> entrada = Mono.zip(responseSec, responseSec2)
				.flatMap(tuples -> {
					return getEpisodeById(idEpisode);
				});

		return entrada;
	}
	
	
	public Mono<String> getMyEpisodesBought(Long idUser) {
		WebClient client = WebClient.create();
		Mono<String> responseSpec = client.get()
				.uri("http://localhost:8083/cobranca/user/"+idUser)
				.exchangeToMono(response -> {
					if(response.statusCode().equals(HttpStatus.OK)) {
						return response.bodyToMono(String.class);
					} else if(response.statusCode().is4xxClientError()) {
						return Mono.just("Error response");
					} else {
						return response.createException().flatMap(Mono::error);
					}
				});
		return responseSpec;
	}
	
	public Mono<Episode> createEpisode(Episode episode) {
		return repository.save(episode);
	}
	
	public Mono<Episode> updateEpisode(Long episodeId, Episode episode) {
		return repository.save(episode);
	}
	
	public Mono<Void> deleteEpisode(Long episodeId) {
		return repository.deleteById(episodeId);
	}

}
