package br.ufrn.programacaoreativa.webflux.repository;

import java.util.List;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.webflux.model.Season;
import reactor.core.publisher.Flux;

@Repository
@EnableR2dbcRepositories
public interface SeasonRepository extends R2dbcRepository<Season, Long>{

	@Query(value = "SELECT * FROM season WHERE nome LIKE CONCAT('%',:name,'%') AND "
			+ "content_id = :contentid")
	Flux<Season> searchSeasonByNameInContent(@Param("name") String name, @Param("contentid") Long idContent);
}
