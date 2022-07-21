package br.ufrn.programacaoreativa.webflux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.webflux.model.Episode;

@Repository
@EnableR2dbcRepositories
public interface EpisodeRepository extends R2dbcRepository<Episode, Long>{

}
