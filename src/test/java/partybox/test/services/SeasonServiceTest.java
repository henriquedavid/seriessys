package partybox.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import partybox.model.Season;
import partybox.services.EpisodeService;
import partybox.services.SeasonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SeasonServiceTest {
	
	private EpisodeService episodeService;
	private SeasonService service;
	
	public SeasonServiceTest() {
		this.episodeService = new EpisodeService();
		this.service = new SeasonService(episodeService);
	}
	
	@Test
	public void getAllSeason() {
		Flux<Season> seasons = service.getAllSeason();
		StepVerifier.create(seasons)
		.assertNext(season -> {
			assertEquals(1, season.getId());
			assertEquals("The End", season.getName());
			assertEquals(1, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(2, season.getId());
			assertEquals("Fly away", season.getName());
			assertEquals(2, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(3, season.getId());
			assertEquals("Our history", season.getName());
			assertEquals(1, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(4, season.getId());
			assertEquals("Last Time", season.getName());
			assertEquals(3, season.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasonsFromContent() {
		Flux<Season> seasons = service.getSeasonsFromContent(3);
		StepVerifier.create(seasons)
		.assertNext(season -> {
			assertEquals(4, season.getId());
			assertEquals("Last Time", season.getName());
			assertEquals(3, season.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasonById() {
		Mono<Season> season = service.getSeasonById(2);
		StepVerifier.create(season)
		.assertNext(season_ -> {
			assertEquals(2, season_.getId());
			assertEquals("Fly away", season_.getName());
			assertEquals(2, season_.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasonByName() {
		Mono<Season> season = service.getSeasonByName("Our history");
		StepVerifier.create(season)
		.assertNext(season_ -> {
			assertEquals(3, season_.getId());
			assertEquals("Our history", season_.getName());
			assertEquals(1, season_.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasons() {
		Flux<Season> seasons = service.getSeasons();
		StepVerifier.create(seasons)
		.assertNext(season -> {
			assertEquals(1, season.getId());
			assertEquals("The End", season.getName());
			assertEquals(1, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(2, season.getId());
			assertEquals("Fly away", season.getName());
			assertEquals(2, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(3, season.getId());
			assertEquals("Our history", season.getName());
			assertEquals(1, season.getIdContent());
		})
		.assertNext(season -> {
			assertEquals(4, season.getId());
			assertEquals("Last Time", season.getName());
			assertEquals(3, season.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasonByEpisodeId() {
		Mono<Season> season = service.getSeasonByEpisodeId(2);
		StepVerifier.create(season)
		.assertNext(season_ -> {
			assertEquals(1, season_.getId());
			assertEquals("The End", season_.getName());
			assertEquals(1, season_.getIdContent());
		})
		.verifyComplete();
	}
	
	@Test
	public void getSeasonByEpisodeName() {
		Flux<Season> seasons = service.getSeasonByEpisodeName("The Last Breath");
		StepVerifier.create(seasons)
		.assertNext(season -> {
			assertEquals(3, season.getId());
			assertEquals("Our history", season.getName());
			assertEquals(1, season.getIdContent());
		})
		.verifyComplete();
	}

}
