package br.ufrn.programacaoreativa.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.userinfo.model.User;
import br.ufrn.programacaoreativa.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> obterDadosDoUsuario(@PathVariable(name = "id") Integer id){
		System.out.println("ENtrou");
			return ResponseEntity.ok(service.findById(id).get());
	}

}
