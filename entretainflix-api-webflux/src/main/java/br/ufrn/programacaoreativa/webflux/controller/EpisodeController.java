package br.ufrn.programacaoreativa.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.webflux.model.Episode;
import br.ufrn.programacaoreativa.webflux.model.EpisodesDTO;
import br.ufrn.programacaoreativa.webflux.repository.EpisodeRepository;
import br.ufrn.programacaoreativa.webflux.service.EpisodeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
	
	@Autowired
	private EpisodeService service;
	

	@GetMapping
	public Flux<Episode> getAllEpisodes(){
		return service.getAllEpisodes();
	}
	
	@GetMapping("/watch/{iduser}/{idepisode}")
	public Mono<Episode> watchEpisode(@PathVariable("iduser") Long idUser, @PathVariable("idepisode") Long idEpisode){
		return service.payEpisode(idUser, idEpisode);
	}
	
	@GetMapping("/my/{iduser}")
	public Mono<String> getMyEpisodes(@PathVariable("iduser") Long idUser){
		return service.getMyEpisodesBought(idUser);
	}
	
	@GetMapping("/{id}")
	public Mono<Episode> getEpisodeById(@PathVariable("id") Long id){
		return service.getEpisodeById(id);
	}
	
	@PostMapping
	public Mono<Episode> createEpisode(@RequestBody Episode episode){
		return service.createEpisode(episode);
	}
	
	@PutMapping("/{id}")
	public Mono<Episode> atualizarEpisode(@PathVariable("/{id}") Long episodeId, @RequestBody Episode episode){
		return service.updateEpisode(episodeId, episode);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteEpisode(@PathVariable("id") Long episodeId){
		return service.deleteEpisode(episodeId);
	}
}
