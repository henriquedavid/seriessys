package br.ufrn.programacaoreativa.payment.respository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.payment.model.Cobranca;



@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Integer>{
	
	@Query(value = "SELECT * FROM cobranca WHERE usuario = :id", nativeQuery = true)
	Set<Cobranca> findAllCobrancaByUser(@Param(value = "id") Integer id);

}
