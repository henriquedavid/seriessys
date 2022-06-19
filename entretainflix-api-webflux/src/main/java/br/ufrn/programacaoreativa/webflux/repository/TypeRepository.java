package br.ufrn.programacaoreativa.webflux.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.webflux.model.Type;
import reactor.core.publisher.Flux;

@Repository
@EnableR2dbcRepositories
public interface TypeRepository extends R2dbcRepository<Type, Long>{

	@Query("SELECT * FROM type WHERE name LIKE CONCAT('%',:name,'%')")
	Flux<Type> findTypeByName(@Param("name") String name);
}
