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

import br.ufrn.programacaoreativa.webflux.model.Type;
import br.ufrn.programacaoreativa.webflux.repository.TypeRepository;
import br.ufrn.programacaoreativa.webflux.service.TypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/type")
public class TypeController {
	 
	@Autowired
	private TypeService service;
	
	@GetMapping
	public Flux<Type> getTypes(){
		return service.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public Mono<Type> getTypeById(@PathVariable("id") Long idType){
		return service.findTypeById(idType);
	}
	
	@PostMapping
	public Mono<Type> createType(@RequestBody Type type){
		return service.createType(type);
	}
	
	@GetMapping("/search/name")
	public Flux<Type> searchByName(@RequestBody Type type){
		return service.searchTypeByName(type.getName());
	}
	
	@PutMapping("/{id}")
	public Mono<Type> updateType(@PathVariable("id") Long typeId, @RequestBody Type type){
		return service.updateType(typeId, type);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteType(@PathVariable("id") Long typeId){
		return service.deleteType(typeId);
	}

}
