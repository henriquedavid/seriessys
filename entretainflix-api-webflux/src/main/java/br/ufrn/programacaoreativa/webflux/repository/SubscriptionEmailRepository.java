package br.ufrn.programacaoreativa.webflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import br.ufrn.programacaoreativa.webflux.model.SubscriptionEmail;

public interface SubscriptionEmailRepository extends R2dbcRepository<SubscriptionEmail, Long>{

}
