package br.ufrn.programacaoreativa.webflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.model.Type;
import br.ufrn.programacaoreativa.webflux.repository.TypeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeService {
	
	@Autowired
	private TypeRepository repository;


	public Flux<Type> getAllTypes(){
		return repository.findAll();
	}
	
	public Mono<Type> findTypeById(Long id){
		return repository.findById(id);
	}
	
	public Mono<Type> createType(Type type) {
		return repository.save(type);
	}
	
	public Flux<Type> searchTypeByName(String type) {
		return repository.findTypeByName(type);
	}
	
	public Mono<Type> updateType(Long typeId, Type type) {
		return repository.save(type);
	}
	
	public Mono<Void> deleteType(Long typeId) {
		return repository.deleteById(typeId);
	}
}
