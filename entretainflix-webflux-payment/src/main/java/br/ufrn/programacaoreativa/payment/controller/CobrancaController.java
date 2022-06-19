package br.ufrn.programacaoreativa.payment.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.payment.model.Cobranca;
import br.ufrn.programacaoreativa.payment.model.DadosCobrancaDTO;
import br.ufrn.programacaoreativa.payment.service.CobrancaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/cobranca")
public class CobrancaController {
	
	@Autowired
	private CobrancaService service;
	
	@PostMapping
	public Mono<Cobranca> receberPagamento(@RequestBody DadosCobrancaDTO dadosCobrancaDTO ) {
		return service.createCobranca(dadosCobrancaDTO);
	}
	
	@GetMapping("/user/{id}")
	public Flux<Cobranca> obterEpisodiosJaPagos(@PathVariable("id") Integer idUser) {
		return service.getCobrancasJaFeitas(idUser);
	}

}
