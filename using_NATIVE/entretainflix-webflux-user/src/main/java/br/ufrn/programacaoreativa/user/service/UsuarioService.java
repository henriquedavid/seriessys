package br.ufrn.programacaoreativa.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.user.model.Usuario;
import br.ufrn.programacaoreativa.user.repository.UsuarioRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Flux<Usuario> getUsers(){
		return repository.findAll();
	}
	
	public Mono<Usuario> findById(Integer id) {
		return repository.findById(id);
	}
	
	public Mono<Usuario> createUser(Mono<Usuario> user) {
		return repository.saveAll(user).next();
	}
	
	public Mono<Usuario> updateUser(Mono<Usuario> user) {
		return repository.saveAll(user).next();
	}

}
