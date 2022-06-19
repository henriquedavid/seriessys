package br.ufrn.programacaoreativa.mvc.controller;

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

import br.ufrn.programacaoreativa.mvc.model.Episode;
import br.ufrn.programacaoreativa.mvc.service.EpisodeService;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
	
	@Autowired
	EpisodeService service;
	
	@GetMapping
	public ResponseEntity<List<Episode>> getAllEpisodes(){
		return ResponseEntity.ok(service.getAllEpisodes());
	}
	
	@GetMapping("/watch/{iduser}/{idepisode}")
	public ResponseEntity<Episode> watchEpisode(@PathVariable("iduser") Long idUser, @PathVariable("idepisode") Long idEpisode){
		return ResponseEntity.ok(service.payEpisode(idUser, idEpisode));
	}
	
	@GetMapping("/my/{iduser}")
	public ResponseEntity<List<Episode>> getMyEpisodes(@PathVariable("iduser") Long idUser){
		return ResponseEntity.ok(service.getMyEpisodesBought(idUser));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Episode> getEpisodeById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.getEpisodeById(id));
	}
	
	@PostMapping
	public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode){
		return ResponseEntity.ok(service.createEpisode(episode));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Episode> atualizarEpisode(@PathVariable("/{id}") Long episodeId, @RequestBody Episode episode){
		return ResponseEntity.ok(service.updateEpisode(episodeId, episode));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Episode> deleteEpisode(@PathVariable("id") Long episodeId){
		return ResponseEntity.ok(service.deleteEpisode(episodeId));
	}

}
