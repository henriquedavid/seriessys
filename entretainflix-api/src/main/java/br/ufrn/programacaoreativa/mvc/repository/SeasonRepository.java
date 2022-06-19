package br.ufrn.programacaoreativa.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.mvc.model.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{

	@Query(value = "SELECT * FROM season WHERE nome LIKE CONCAT('%',:name,'%') AND "
			+ "content_id = :contentid", nativeQuery = true)
	List<Season> searchSeasonByNameInContent(@Param("name") String name, @Param("contentid") Long idContent);
}
