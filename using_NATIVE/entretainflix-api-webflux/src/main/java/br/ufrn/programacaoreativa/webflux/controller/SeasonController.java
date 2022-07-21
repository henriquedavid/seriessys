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

import br.ufrn.programacaoreativa.webflux.model.BuscaDTO;
import br.ufrn.programacaoreativa.webflux.model.Season;
import br.ufrn.programacaoreativa.webflux.repository.SeasonRepository;
import br.ufrn.programacaoreativa.webflux.service.SeasonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/season")
public class SeasonController {
	
	@Autowired
	private SeasonService service;


	@GetMapping
	public Flux<Season> getAllSeason(){
		return service.getAllSeason();
	}
	
	@GetMapping("/{id}")
	public Mono<Season> getSeasonById(@PathVariable("id") Long idSeason){
		return service.getSeasonById(idSeason);
	}
	
	@GetMapping("/search/content/{id}")
	public Flux<Season> searchSeasonByNameByContentId(@RequestBody Mono<BuscaDTO> busca, @PathVariable("id") Long contentId){
		return service.searchSeasonByNameInContent(busca, contentId);
	}
	
	@PostMapping
	public Mono<Season> createSeason(@RequestBody Mono<Season> season){
		return service.createSeason(season);
	}
	
	@PutMapping
	public Mono<Season> updateSeason(@RequestBody Mono<Season> season){
		return service.updateSeason(season);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteSeason(@PathVariable("id") Long id){
		return service.deleteSeason(id);
	}
}
