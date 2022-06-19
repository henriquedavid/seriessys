package br.ufrn.programacaoreativa.payment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.payment.model.Cobranca;
import br.ufrn.programacaoreativa.payment.model.DadosCobrancaDTO;
import br.ufrn.programacaoreativa.payment.respository.CobrancaRepository;

@Service
public class CobrancaService {
	
	@Autowired
	private CobrancaRepository repository;
	
	public List<Cobranca> getCobrancas(){
		return repository.findAll();
	}
	
	public Optional<Cobranca> getCobrancaById(Integer id) {
		return repository.findById(id);
	}
	
	public Cobranca createCobranca(DadosCobrancaDTO cobrancaDTO) {
		Cobranca cobranca = new Cobranca();
		cobranca.setDatapagamento(new Date());
		cobranca.setEpisode(cobrancaDTO.getEpisodeId());
		cobranca.setUsuario(cobrancaDTO.getUserId());
		Random random = new Random(); 
		if((random.nextInt()%2) == 0) {
			cobranca.setStatusTransacao("APROVADO");
		} else {
			cobranca.setStatusTransacao("RECUSADO");
		}
		return repository.save(cobranca);
	}
	
	public Set<Cobranca> getCobrancasJaFeitas(Integer idUser) {
		return repository.findAllCobrancaByUser(idUser);
	}

}
