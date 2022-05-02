package partybox.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import partybox.Main;
import partybox.model.Category;
import partybox.model.Series;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CategoryService {
	
	public Flux<Category> getAllCategory(){
		List<Category> books = Arrays.asList(
				new Category(1, "Suspense"),
				new Category(2, "Ação"),
				new Category(3, "Aventura"),
				new Category(4, "Terror"),
				new Category(5, "Comédia"),
				new Category(6, "Romance"));
		
		return Flux.fromIterable(books);
	}
	
	public Mono<Category> getCategoryById(int idBook){
		return Mono.just(new Category(idBook, "Name"));
	}
	
	public Mono<Category> getCategoryByName(String name){
		return getAllCategory().filterWhen(category -> Mono.just(category.getNome().equals(name))).last();
	}
	
	//-------------------------------------------------------------------------------
	
	public Flux<Void> addCategory(Category cat){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						// Process to add
						sink.complete();
					}
					return 0;
				});
	}
	
	public Flux<Void> alterCategory(Integer id, Category element){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						// Process to alter
						sink.complete();
					}
					return 0;
				});
	}
	
	
	public Flux<Void> removeCategory(Integer id){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						// Process to remove
						sink.complete();
					}
					return 0;
				});
	}
	

}
