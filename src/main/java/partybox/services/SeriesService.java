package partybox.services;

import java.util.ArrayList;
import java.util.Date;

import partybox.Main;
import partybox.model.Category;
import partybox.model.Series;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SeriesService {
	
	private ArrayList<Category> categorias = Main.category; 
	
	public Flux<Category> getAllCategories(){
		return Flux.fromIterable(categorias);
	}
	
	public Flux<Series> getFirst10SeriesFromCategory(Integer category){
		return Flux.fromIterable(categorias.get(category).getSeries()).take(10);
	}
	
	public Flux<Series> getFirst10SeriesFromCategoryEnd(Integer category){
		return Flux.fromIterable(categorias.get(category).getSeries()).takeLast(10);
	}
	
	public Flux<Void> addSerieToCategory(Integer category, Integer id, String nome, String description, Date date){
		return Flux.generate(() -> 0,
				(state, sink) -> {
					if(state == 0) {
						categorias.get(category).getSeries().add(new Series(id, nome, description, date));
						sink.complete();
					}
					return 1;
				});
	}
	
	public Flux<Void> removeSerieFromCategory(Integer idCategory, Integer idElement){
		return Flux.generate(() -> 0, 
				(state, sink) -> {
					if(state == 0) {
						categorias.get(idCategory).getSeries().remove(idElement);
					} else {
						sink.complete();
					}
					return 1;
				});
	}

}
