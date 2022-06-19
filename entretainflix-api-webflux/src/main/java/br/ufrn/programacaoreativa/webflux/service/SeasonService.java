package br.ufrn.programacaoreativa.webflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.model.BuscaDTO;
import br.ufrn.programacaoreativa.webflux.model.Season;
import br.ufrn.programacaoreativa.webflux.repository.SeasonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeasonService {
	
	@Autowired
	private SeasonRepository repository;

	public Flux<Season> getAllSeason(){
		return repository.findAll();
	}
	
	public Mono<Season> getSeasonById(Long id) {
		return repository.findById(id);
	}
	
	public Flux<Season> searchSeasonByNameInContent(BuscaDTO busca, Long contentId) {
		return repository.searchSeasonByNameInContent(busca.getName(), contentId);
	}
	
	public Mono<Season> createSeason(Season season) {
		return repository.save(season);
	}
	
	public Mono<Season> updateSeason(Long seasonId, Season season) {
		return repository.findById(seasonId);
	}
	
	public Mono<Season> deleteSeason(Long seasonId) {
		return repository.findById(seasonId);
	}
}
