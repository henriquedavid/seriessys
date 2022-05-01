package partybox;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import partybox.config.InitiateDatabase;
import partybox.model.Category;
import partybox.model.People;
import partybox.model.Series;
import partybox.services.SeriesService;
import reactor.core.publisher.Flux;

/**
 * Catálogos de séries, os usuários podem se inscreverem 
 * @author henrique
 *
 */

public class Main {
	
	public static final ArrayList<People> people = new ArrayList<People>();
	public static final ArrayList<Category> category = new ArrayList<Category>();

	public static void main(String[] args) {
		
//		category.get(0).getSeries().add(new Series(1,"Teste-1", null, null));
//		category.get(0).getSeries().add(new Series(2,"Teste-2", null, null));
//		category.get(0).getSeries().add(new Series(3,"Teste-3", null, null));
//		category.get(0).getSeries().add(new Series(4,"Teste-4", null, null));
//
//		people.add(new People("Pessoa-1"));
//		people.add(new People("Pessoa-2"));
//		people.add(new People("Pessoa-3"));
		
		InitiateDatabase initialize = new InitiateDatabase();
		SeriesService service = new SeriesService();
		
		Flux<Category> events = initialize.init();
		
		Flux<Series> series = Flux.concat(events.map(mapper -> Flux.fromIterable(mapper.getSeries())));
		
//		service.addSerieToCategory(1, 5, "Exemplo1", "Esse é apenas um exemplo", new Date("2022/10/10"));
		
//		Flux<Series> events = service.getFirst10SeriesFromCategory(1).delaySubscription(Duration.ofMillis(5000));
		
		series.subscribe(p1 -> System.out.println("Entrou= " + p1.getName()));
		
		
		
	}

}
