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

import br.ufrn.programacaoreativa.mvc.model.Type;
import br.ufrn.programacaoreativa.mvc.service.TypeService;

@RestController
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	TypeService service;
	
	@GetMapping
	public ResponseEntity<List<Type>> getTypes(){
		return ResponseEntity.ok(service.getAllTypes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable("id") Long idType){
		return ResponseEntity.ok(service.findTypeById(idType));
	}
	
	@PostMapping
	public ResponseEntity<Type> createType(@RequestBody Type type){
		return ResponseEntity.ok(service.createType(type));
	}
	
	@GetMapping("/search/name")
	public ResponseEntity<List<Type>> searchByName(@RequestBody Type type){
		return ResponseEntity.ok(service.searchTypeByName(type.getName()));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Type> updateType(@PathVariable("id") Long typeId, @RequestBody Type type){
		return ResponseEntity.ok(service.updateType(typeId, type));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Type> deleteType(@PathVariable("id") Long typeId){
		return ResponseEntity.ok(service.deleteType(typeId));
	}

}
