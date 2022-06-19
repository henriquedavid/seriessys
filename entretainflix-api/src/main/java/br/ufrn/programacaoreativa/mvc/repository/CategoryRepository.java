package br.ufrn.programacaoreativa.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.mvc.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(value = "SELECT * FROM category WHERE nome LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Category> searchCategoryByName(@Param("name") String name);
}
