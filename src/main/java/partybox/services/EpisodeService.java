package partybox.services;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import partybox.model.Episode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EpisodeService {
	
	
	public EpisodeService() {
		super();
	}

	public Flux<Episode> findAllEpisodes(){
		return Flux.fromIterable(Arrays.asList(
				new Episode(1, "Episode 1", Duration.ofMinutes(45), new Date("2022/10/10"), 1),
				new Episode(2, "Episode 2", Duration.ofMinutes(41), new Date("2022/10/11"), 1),
				new Episode(3, "Our History", Duration.ofMinutes(44), new Date("2022/02/01"), 2),
				new Episode(4, "Episode 4", Duration.ofMinutes(46), new Date("2022/10/12"), 1),
				new Episode(5, "The Last Breath", Duration.ofMinutes(42), new Date("2022/03/14"), 3),
				new Episode(6, "Episode 5", Duration.ofMinutes(50), new Date("2022/10/13"), 1)
				));
	}
	
	public Mono<Episode> findEpisodeById(int idEpisode){
		return findAllEpisodes().filterWhen(episode -> Mono.just(episode.getId() == idEpisode)).last();
	}
	
	public Flux<Episode> findEpisodeByName(String name){
		return findAllEpisodes().filterWhen(episode -> Mono.just(episode.getName().equals(name)));
	}
	
	public Flux<Episode> findEpisodesBySeasonId(int idSeason){
		return findAllEpisodes().filterWhen(episode -> Mono.just(episode.getIdSeason() == idSeason));
	}

}
