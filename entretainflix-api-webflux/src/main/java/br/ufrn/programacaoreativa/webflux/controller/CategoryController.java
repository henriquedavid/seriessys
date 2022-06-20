package br.ufrn.programacaoreativa.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.programacaoreativa.webflux.model.BuscaDTO;
import br.ufrn.programacaoreativa.webflux.model.Category;
import br.ufrn.programacaoreativa.webflux.repository.CategoryRepository;
import br.ufrn.programacaoreativa.webflux.service.CategoryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	

	@GetMapping
	public Flux<Category> getCategories(){
		return service.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Mono<Category> getCategoryById(@PathVariable("id") Long idCategory){
		return service.findCategoryById(idCategory);
	}
	
	@GetMapping("/search/name")
	public Flux<Category> searchCategoryByName(@RequestBody BuscaDTO busca){
		return service.searchCategoryByName(busca.getName());
	}
	
	@PostMapping
	public Mono<Category> addCategory(@RequestBody Category category){
		return service.addCategory(category);
	}
	
	@PutMapping("/{id}")
	public Mono<Category> updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category){
		return service.updateCategory(categoryId, category);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> removeCategory(@PathVariable("id") Long categoryId){
		return service.deleteCategory(categoryId);
	}

}
