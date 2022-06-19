package br.ufrn.programacaoreativa.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.webflux.repository.SeasonRepository;

@RestController
@RequestMapping("/season")
public class SeasonController {
	
	@Autowired
	private SeasonRepository repository;

}
