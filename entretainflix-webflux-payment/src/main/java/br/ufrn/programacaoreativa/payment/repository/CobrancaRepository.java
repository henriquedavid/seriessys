package br.ufrn.programacaoreativa.payment.repository;

import java.util.Set;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.payment.model.Cobranca;
import reactor.core.publisher.Flux;

@Repository
@EnableR2dbcRepositories
public interface CobrancaRepository extends R2dbcRepository<Cobranca, Integer>{
	
	@Query("SELECT * FROM cobranca WHERE usuario = :id")
	Flux<Cobranca> findAllCobrancaByUser(@Param(value = "id") Integer id);

}
