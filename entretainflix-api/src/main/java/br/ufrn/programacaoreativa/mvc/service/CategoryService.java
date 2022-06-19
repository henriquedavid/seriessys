package br.ufrn.programacaoreativa.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.mvc.model.Category;
import br.ufrn.programacaoreativa.mvc.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;

	public List<Category> getAllCategories(){
		return repository.findAll();
	}
	
	public Optional<Category> findCategoryById(Long id) {
		return repository.findById(id);
	}
	
	public List<Category> searchCategoryByName(String name) {
		return repository.searchCategoryByName(name);
	}
	
	public Category addCategory(Category category) {
		if(repository.searchCategoryByName(category.getNome()).size() == 0) {
			return repository.save(category);
		}
		else
			return null;
	}
	
	public Category updateCategory(Long categoryId, Category category) {
		if(repository.findById(categoryId).isPresent()) {
			category.setId(categoryId);
			return repository.save(category);
		} else {
			return null;
		}
		
	}
	
	public Category deleteCategory(Long categoryId) {
		Optional<Category> category_ = repository.findById(categoryId);
		if(category_.isPresent()) {
			repository.deleteById(categoryId);
			return category_.get();
		} else {
			return null;
		}
	}

}
