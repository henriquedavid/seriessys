package br.ufrn.programacaoreativa.mvc.service;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import br.ufrn.programacaoreativa.mvc.model.Episode;
import br.ufrn.programacaoreativa.mvc.model.EpisodesDTO;
import br.ufrn.programacaoreativa.mvc.model.User;
import br.ufrn.programacaoreativa.mvc.model.dto.DadosPagamentoDTO;
import br.ufrn.programacaoreativa.mvc.repository.EpisodeRepository;

@Service
public class EpisodeService {
	
	@Autowired
	EpisodeRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(EpisodeService.class);
	
	public List<Episode> getAllEpisodes(){
		return repository.findAll();
	}
	
	public Episode getEpisodeById(Long id) {
		Optional<Episode> episode_ = repository.findById(id);
		if(episode_.isPresent())
			return episode_.get();
		else
			return null;
	}
	
	public User getUserThatBoughtEpisodes(Long idUser){
		return this.restTemplate.getForObject("http://userentretainflix/user/"+idUser, User.class);
	}
	
	public Episode payEpisode(Long idUser, Long idEpisode) {
		
		Episode episode = getEpisodeById(idEpisode);
		
		System.out.println(episode.getName());
		
		User user_ = this.restTemplate.getForObject("http://userentretainflix/user/"+idUser, User.class);		
		
		HttpEntity<DadosPagamentoDTO> request = new HttpEntity<DadosPagamentoDTO>(new DadosPagamentoDTO(user_.getId(), episode.getId(), 3.25));
		String request_ = this.restTemplate.postForObject("http://entretainflixpagamento/cobranca", request, String.class);
		
		return episode;
	}
	
	public List<EpisodesDTO> getMyEpisodesBought(Long idUser) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		EpisodesDTO[] episodes = this.restTemplate.getForObject("http://entretainflixpagamento/cobranca/user/"+idUser, EpisodesDTO[].class);
		
		return Arrays.asList(episodes);
	}
	
	public Episode createEpisode(Episode episode) {
		return repository.save(episode);
	}
	
	public Episode updateEpisode(Long episodeId, Episode episode) {
		if(repository.findById(episodeId).isPresent()) {
			episode.setId(episodeId);
			return repository.save(episode);
		} else
			return null;
	}
	
	public Episode deleteEpisode(Long episodeId) {
		Optional<Episode> episode_ = repository.findById(episodeId);
		if(episode_.isPresent()) {
			repository.deleteById(episodeId);
			return episode_.get();
		} else {
			return null;
		}
	}

}
