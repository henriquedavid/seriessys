package br.ufrn.programacaoreativa.mvc.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import br.ufrn.programacaoreativa.mvc.model.Episode;
import br.ufrn.programacaoreativa.mvc.model.EpisodesDTO;
import br.ufrn.programacaoreativa.mvc.model.User;
import br.ufrn.programacaoreativa.mvc.repository.EpisodeRepository;

@Service
public class EpisodeService {
	
	@Autowired
	EpisodeRepository repository;
	
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
	
	public Episode payEpisode(Long idUser, Long idEpisode) {
		
		Episode episode = getEpisodeById(idEpisode);
		
		System.out.println(episode.getName());
		
		User user_ = null;
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://user-entretainflix:8082/user/"+idUser))
					.GET()
					.build();
			
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
			
			user_ = objectMapper.readValue(response.body(), User.class);
			
			System.out.println(user_.getName());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível realizar a conexão com o usuario");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A conexão com o usuário foi interrompida");
		}
		
		String body = "{\"userId\": " + user_.getId() + ", \"episodeId\" : " + episode.getId() + " , \"valor\" : " + 3.25 + "}";
		
		System.out.println(body);
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://entretainflix-pagamento/cobranca"))
					.header("content-type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(body))
					.build();
			
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
			
			System.out.println("Passou aqui");
			System.out.println(response.body());
		} catch (URISyntaxException e) {
			logger.error("Não foi possível realizar o pagamento");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URI incorreta");
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível realizar a conexão com o pagamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A conexão com o pagamento foi interrompida");
		}
		
		return episode;
	}
	
	public List<Episode> getMyEpisodesBought(Long idUser) {
		
		List<Episode> episodes = new ArrayList<Episode>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://entretainflix-pagamento/cobranca/user/"+idUser))
					.GET()
					.build();
			
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
			
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			episodes = objectMapper.readValue(response.body(), typeFactory.constructCollectionType(List.class, EpisodesDTO.class));
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return episodes;
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
