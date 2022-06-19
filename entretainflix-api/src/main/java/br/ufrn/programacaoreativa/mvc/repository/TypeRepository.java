package br.ufrn.programacaoreativa.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.mvc.model.Type;


@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{

	@Query(value = "SELECT * FROM type WHERE name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Type> findTypeByName(@Param("name") String name);
}
