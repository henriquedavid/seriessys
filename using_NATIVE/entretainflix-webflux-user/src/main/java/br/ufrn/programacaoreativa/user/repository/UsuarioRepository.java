package br.ufrn.programacaoreativa.user.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.user.model.Usuario;

@Repository
@EnableR2dbcRepositories
public interface UsuarioRepository extends R2dbcRepository<Usuario, Integer>{

	

}
