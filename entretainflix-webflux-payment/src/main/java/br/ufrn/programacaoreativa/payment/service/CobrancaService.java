package br.ufrn.programacaoreativa.payment.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.payment.model.Cobranca;
import br.ufrn.programacaoreativa.payment.model.DadosCobrancaDTO;
import br.ufrn.programacaoreativa.payment.repository.CobrancaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CobrancaService {
	
	@Autowired
	private CobrancaRepository repository;
	
	public Flux<Cobranca> getCobrancas(){
		return repository.findAll();
	}
	
	public Mono<Cobranca> getCobrancaById(Integer id) {
		return repository.findById(id);
	}
	
	public Mono<Cobranca> createCobranca(Mono<DadosCobrancaDTO> cobrancaDTO) {
		return cobrancaDTO.flatMap(item -> {
			Cobranca c = new Cobranca();
			c.setDatapagamento(LocalDateTime.now());
			c.setEpisode(item.getEpisodeId());
			c.setUsuario(item.getUserId());
			Random random = new Random(); 
			if((random.nextInt()%2) == 0) {
				 c.setStatusTransacao("APROVADO");
			} else {
				c.setStatusTransacao("RECUSADO");
			}
			
			return repository.save(c);
		});
	}
	
	public Flux<Cobranca> getCobrancasJaFeitas(Integer idUser) {
		return repository.findAllCobrancaByUser(idUser);
	}

}
