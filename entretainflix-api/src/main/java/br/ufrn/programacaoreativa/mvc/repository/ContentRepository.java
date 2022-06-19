package br.ufrn.programacaoreativa.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.mvc.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{
	
	@Query(value = "SELECT * FROM content WHERE nome LIKE CONCAT('%',:name,'%')", nativeQuery = true)
	List<Content> findContentByName(@Param("name") String name);

}
