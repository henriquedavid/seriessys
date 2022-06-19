package br.ufrn.programacaoreativa.webflux.repository;

import java.util.List;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.webflux.model.Category;
import reactor.core.publisher.Flux;

@Repository
@EnableR2dbcRepositories
public interface CategoryRepository extends R2dbcRepository<Category, Long> {
	
	@Query(value = "SELECT * FROM category WHERE nome LIKE CONCAT('%',:name,'%')")
	Flux<Category> searchCategoryByName(@Param("name") String name);
}
