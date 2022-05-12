package partybox.services;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import partybox.Main;
import partybox.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

public class CategoryService {
	
	public List<Category> categories = Arrays.asList(
		new Category(1, "Suspense"),
		new Category(2, "Ação"),
		new Category(3, "Aventura"),
		new Category(4, "Terror"),
		new Category(5, "Comédia"),
		new Category(6, "Romance")
	);
	
	public Flux<Category> getAllCategory(){
		return Flux.fromIterable(categories);
	}
	
	public Mono<Category> getCategoryById(int idBook){
		return getAllCategory().filterWhen(category -> Mono.just(category.getId() == idBook)).last();
	}
	
	public Mono<Category> getCategoryByName(String name){
		return getAllCategory().filterWhen(category -> Mono.just(category.getNome().equals(name))).last();
	}
	

}
