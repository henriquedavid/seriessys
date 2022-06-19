package br.ufrn.programacaoreativa.userinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.programacaoreativa.userinfo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
