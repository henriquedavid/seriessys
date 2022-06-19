package br.ufrn.programacaoreativa.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.mvc.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long>{
//	
//	@Query(value = "SELECT * FROM content WHERE nome LIKE CONCAT('%',:name,'%')"
//			+ " AND episodeId = ", nativeQuery = true)
//	List<Episode> searchEpisodeByNameInAContent(@Param("name") String name, @Param("id") Long idContent);

}
