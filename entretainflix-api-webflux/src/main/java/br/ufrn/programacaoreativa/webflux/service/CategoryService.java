package br.ufrn.programacaoreativa.webflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.model.Category;
import br.ufrn.programacaoreativa.webflux.repository.CategoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Flux<Category> getAllCategories(){
		return repository.findAll();
	}
	
	public Mono<Category> findCategoryById(Long id) {
		return repository.findById(id);
	}
	
	public Flux<Category> searchCategoryByName(String name) {
		return repository.searchCategoryByName(name);
	}
	
	public Mono<Category> addCategory(Category category) {
		return repository.save(category);
	}
	
	public Mono<Category> updateCategory(Long categoryId, Category category) {
		return repository.save(category);
	}
	
	public Mono<Void> deleteCategory(Long categoryId) {
		return repository.deleteById(categoryId);
	}

}
