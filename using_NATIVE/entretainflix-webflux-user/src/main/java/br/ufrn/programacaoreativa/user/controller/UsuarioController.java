package br.ufrn.programacaoreativa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.user.model.Usuario;
import br.ufrn.programacaoreativa.user.service.UsuarioService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{id}")
	public Mono<Usuario> obterDadosDoUsuario(@PathVariable(name = "id") Integer id){
		return service.findById(id);
	}

}
