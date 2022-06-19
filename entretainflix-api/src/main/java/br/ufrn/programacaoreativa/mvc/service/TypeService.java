package br.ufrn.programacaoreativa.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.mvc.model.Type;
import br.ufrn.programacaoreativa.mvc.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository repository;
	
	public List<Type> getAllTypes(){
		return repository.findAll();
	}
	
	public Type findTypeById(Long id){
		Optional<Type> type_ = repository.findById(id);
		if(type_.isPresent())
			return type_.get();
		else
			return null;
	}
	
	public Type createType(Type type) {
		List<Type> type_ = repository.findTypeByName(type.getName());
		if(type != null && type.getName() != null && type_.size() == 0 && !type.getName().equals("")) {
			return repository.save(type);
		} else
			return null;
	}
	
	public List<Type> searchTypeByName(String type) {
		return repository.findTypeByName(type);
	}
	
	public Type updateType(Long typeId, Type type) {
		Optional<Type> type_ = repository.findById(typeId);
		if(type_.isPresent()) {
			type.setId(typeId);
			return repository.save(type);
		} else {
			return null;
		}
	}
	
	public Type deleteType(Long typeId) {
		Optional<Type> type_ = repository.findById(typeId);
		if(type_.isPresent()) {
			repository.deleteById(typeId);
			return type_.get();
		} else {
			return null;
		}
	}

}
