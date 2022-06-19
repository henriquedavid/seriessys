package br.ufrn.programacaoreativa.userinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.userinfo.model.User;
import br.ufrn.programacaoreativa.userinfo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return repository.findById(id);
	}
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}

}
