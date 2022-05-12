package partybox.services;

import java.util.Arrays;
import java.util.List;

import partybox.model.Episode;
import partybox.model.Season;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SeasonService {
	
	private EpisodeService episodeService;
		
	public SeasonService(EpisodeService episodeService) {
		super();
		this.episodeService = episodeService;
	}

	public Flux<Season> getAllSeason(){
		return Flux.fromIterable(Arrays.asList(
				new Season(1, "The End", 1),
				new Season(2, "Fly away", 2),
				new Season(3, "Our history", 1),
				new Season(4, "Last Time", 3)
				));
	}
	
	public Flux<Season> getSeasonsFromContent(int idContent){
		return getSeasons().filterWhen(season -> Mono.just(season.getIdContent() == idContent));
	}
	
	public Mono<Season> getSeasonById(int idSeason){
		return getSeasons().filterWhen(season -> Mono.just(season.getId() == idSeason)).last();
	}
	
	public Mono<Season> getSeasonByName(String nameSeason){
		return getSeasons().filterWhen(season -> Mono.just(season.getName().equals(nameSeason))).last();
	}
	
	public Flux<Season> getSeasons(){
		return getAllSeason().flatMap(season -> {
			Mono<List<Episode>> episodes = episodeService.findAllEpisodes().collectList();
			return episodes.map(episode -> new Season(season.getId(), season.getName(), season.getIdContent(), episode));
		});
	}
	
	public Mono<Season> getSeasonByEpisodeId(int idEpisode){
		return episodeService.findEpisodeById(idEpisode)
				.flatMap(episode -> {
					return getAllSeason().filterWhen(season -> Mono.just(episode.getIdSeason() == season.getId())).last();
				});
	}
	
	public Flux<Season> getSeasonByEpisodeName(String name){
		return episodeService.findEpisodeByName(name)
				.flatMap(episode -> {
					return getAllSeason().filterWhen(season -> Mono.just(episode.getIdSeason() == season.getId()));
				});
	}

}
