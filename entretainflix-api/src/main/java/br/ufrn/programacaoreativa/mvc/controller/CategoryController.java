package br.ufrn.programacaoreativa.mvc.controller;

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

import br.ufrn.programacaoreativa.mvc.model.Category;
import br.ufrn.programacaoreativa.mvc.model.dto.BuscaDTO;
import br.ufrn.programacaoreativa.mvc.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories(){
		return ResponseEntity.ok(service.getAllCategories());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long idCategory){
		return ResponseEntity.ok(service.findCategoryById(idCategory).get());
	}
	
	@GetMapping("/search/name")
	public ResponseEntity<List<Category>> searchCategoryByName(@RequestBody BuscaDTO busca){
		return ResponseEntity.ok(service.searchCategoryByName(busca.getName()));
	}
	
	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return ResponseEntity.ok(service.addCategory(category));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category){
		return ResponseEntity.ok(service.updateCategory(categoryId, category));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> removeCategory(@PathVariable("id") Long categoryId){
		return ResponseEntity.ok(service.deleteCategory(categoryId));
	}
	

}
