package partybox.services;

import java.util.Arrays;
import java.util.List;

import partybox.model.Content;
import partybox.model.Season;
import partybox.model.Type;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ContentService {
	
	private CategoryService categoryService;
	private TypeService typeService;
	private SeasonService seasonService;
	
	public ContentService(CategoryService categoryService, TypeService typeService, SeasonService seasonService) {
		super();
		this.categoryService = categoryService;
		this.typeService = typeService;
		this.seasonService = seasonService;
	}

	public Flux<Content> getContent(){
		return Flux.fromIterable(Arrays.asList(
				new Content(1, "Doutor Estranho no Multiverso da Loucura", 2, 2),
				new Content(2, "O Homem do Norte", 2, 2),
				new Content(3, "Thor: Amor e Trovão", 2, 2),
				new Content(4, "Top Gun: Maverick", 1, 1),
				new Content(5, "Jurassic World Domínio", 3, 4)
				));
	}
	
	public Mono<Content> getContentById(int idContent){
		return getAllContent().filterWhen(content -> Mono.just(content.getId() == idContent)).last();
	}
	
	public Flux<Content> getAllContent(){
		return getContent()
				.flatMap((content_) -> {
					Mono<List<Season>> seasons = seasonService.getSeasonsFromContent(content_.getId()).collectList();
					return seasons.map(season -> new Content(content_.getId(), content_.getName(), content_.getIdType(), content_.getIdCategory(), season));
		});
	}
	
	public Mono<Content> getContentByIdComplete(int idContent){
		return getContentById(idContent).zipWith(
				seasonService.getSeasonsFromContent(idContent).collectList(),
				(content_, season_) -> new Content(content_.getId(), content_.getName(), content_.getIdType(), content_.getIdCategory(), season_));
	}
	
	public Flux<Content> getContentByTypeName(String name){
		Mono<List<Content>> content_ = typeService.getTypeByName(name).flatMap(type -> {
			Mono<List<Content>> contents = getAllContent().filterWhen(content -> Mono.just(content.getIdType() == type.getId())).collectList();
			return contents;
		});
		
		return content_.flatMapIterable(content -> content);
	}
	
	public Flux<Content> getContentByCategoryName(String name){
		Mono<List<Content>> contents_ = categoryService.getCategoryByName(name).flatMap(category -> {
			Mono<List<Content>> contents = getAllContent().filterWhen(content -> Mono.just(content.getIdCategory() == category.getId())).collectList();
			return contents;
		});
		return contents_.flatMapIterable(content -> content);
	}
	
	public Flux<Content> getContentByName(String name){
		return getAllContent().filterWhen(content -> Mono.just(content.getName().equals(name)));
	}
	
	public Flux<Content> getSearchNameContent(String name){
		return getAllContent().filterWhen(content -> Mono.just(content.getName().contains(name)));
	}
	

}
