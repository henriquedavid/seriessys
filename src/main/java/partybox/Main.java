package partybox;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import partybox.config.InitiateDatabase;
import partybox.model.Category;
import partybox.model.Content;
import partybox.model.Episode;
import partybox.model.Series;
import partybox.model.Type;
import partybox.services.CategoryService;
import partybox.services.ContentService;
import partybox.services.EpisodeService;
import partybox.services.SeasonService;
import partybox.services.SeriesService;
import partybox.services.TypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Catálogos de séries, os usuários podem se inscreverem 
 * @author henrique
 *
 */

public class Main {
	
	public static final ArrayList<Category> category = new ArrayList<Category>();

	public static void main(String[] args) {
		
		CategoryService categoryService = new CategoryService();
		TypeService typeService = new TypeService();
		SeasonService seasonService = null;
		EpisodeService episodeService = new EpisodeService(seasonService);
		seasonService = new SeasonService(episodeService);
		
		ContentService contentService = new ContentService(categoryService, typeService, seasonService);
		
		{
			/**
			 * Getting all contents
			 */
			System.out.println("-1-");
			Flux<Content> series = contentService.getAllContent();
			series.subscribe(p -> System.out.println("Itens: " + p.toString()));
		}
		
		{
			System.out.println("-2-");
			Mono<Content> series = contentService.getContentByIdComplete(1);
			series.subscribe(p -> System.out.println("Itens: " + p.toString()));
		}
		
		{
			System.out.println("-3-");
			Flux<Content> series = contentService.getContentByTypeName("Film");
			series.subscribe(p -> System.out.println("Itens: " + p.toString()));
		}
		
		{
			System.out.println("-4-");
			Flux<Episode> episodes = episodeService.findAllEpisodes();
			episodes.subscribe(p -> System.out.println("Itens: " + p.toString()));
		}
		
		
		
	}

}
