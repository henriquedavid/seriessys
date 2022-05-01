package partybox.services;

import java.util.ArrayList;

import partybox.Main;
import partybox.model.Category;
import partybox.model.Series;
import reactor.core.publisher.Flux;

public class CategoryService {
	
	private ArrayList<Category> categorias = Main.category;
	
	public Flux<Category> getCategory(){
		return Flux.fromIterable(categorias);
	}
	
	public Flux<Category> findByName(String name){
		return Flux.generate(() -> 0, (state, sink) -> {
			if(categorias.size() < state && categorias.get(state).getNome() == name)
				sink.complete();
			else
				sink.next(categorias.get(state + 1));
			return state + 1;
		});
	}
	
	public Flux<Void> addCategory(Category cat){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						categorias.add(cat);
						sink.complete();
					}
					return 0;
				});
	}
	
	public Flux<Void> alterCategory(Integer id, Category element){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						categorias.set(id, element);
						sink.complete();
					}
					return 0;
				});
	}
	
	
	public Flux<Void> removeCategory(Integer id){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						categorias.remove(id);
						sink.complete();
					}
					return 0;
				});
	}
	

}
