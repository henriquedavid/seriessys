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

import br.ufrn.programacaoreativa.mvc.model.Season;
import br.ufrn.programacaoreativa.mvc.model.dto.BuscaDTO;
import br.ufrn.programacaoreativa.mvc.service.SeasonService;

@RestController
@RequestMapping("/season")
public class SeasonController {
	
	@Autowired
	SeasonService service;
	
	@GetMapping
	public ResponseEntity<List<Season>> getAllSeason(){
		return ResponseEntity.ok(service.getAllSeason());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Season> getSeasonById(@PathVariable("id") Long idSeason){
		return ResponseEntity.ok(service.getSeasonById(idSeason));
	}
	
	@GetMapping("/search/content/{id}")
	public ResponseEntity<List<Season>> searchSeasonByNameByContentId(@RequestBody BuscaDTO busca, @PathVariable("id") Long contentId){
		return ResponseEntity.ok(service.searchSeasonByNameInContent(busca, contentId));
	}
	
	@PostMapping
	public ResponseEntity<Season> createSeason(@RequestBody Season season){
		return ResponseEntity.ok(service.createSeason(season));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Season> updateSeason(@PathVariable("id") Long id, @RequestBody Season season){
		return ResponseEntity.ok(service.updateSeason(id, season));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Season> deleteSeason(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.deleteSeason(id));
	}

}
