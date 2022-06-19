package br.ufrn.programacaoreativa.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.mvc.model.Episode;
import br.ufrn.programacaoreativa.mvc.model.Season;
import br.ufrn.programacaoreativa.mvc.model.dto.BuscaDTO;
import br.ufrn.programacaoreativa.mvc.repository.SeasonRepository;

@Service
public class SeasonService {
	
	@Autowired
	SeasonRepository repository;

	public List<Season> getAllSeason(){
		return repository.findAll();
	}
	
	public Season getSeasonById(Long id) {
		Optional<Season> season_ = repository.findById(id);
		if(season_.isPresent())
			return season_.get();
		else
			return null;
	}
	
	public List<Season> searchSeasonByNameInContent(BuscaDTO busca, Long contentId) {
		return repository.searchSeasonByNameInContent(busca.getName(), contentId);
	}
	
	public Season createSeason(Season season) {
		return repository.save(season);
	}
	
	public Season updateSeason(Long seasonId, Season season) {
		Optional<Season> season_ = repository.findById(seasonId);
		if(season_.isPresent()) {
			season.setId(seasonId);
			return repository.save(season_.get());
		} else {
			return null;
		}
	}
	
	public Season deleteSeason(Long seasonId) {
		Optional<Season> season_ = repository.findById(seasonId);
		if(season_.isPresent()) {
			repository.deleteById(seasonId);
			return season_.get();
		} else {
			return null;
		}
	}
}
