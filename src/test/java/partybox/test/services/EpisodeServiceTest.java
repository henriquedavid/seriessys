package partybox.test.services;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.Test;

import partybox.model.Episode;
import partybox.services.EpisodeService;
import partybox.services.SeasonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class EpisodeServiceTest {
	
	private EpisodeService service;
	
	public EpisodeServiceTest() {
		this.service = new EpisodeService();
	}
	
	@Test
	public void findAllEpisodes() {
		Flux<Episode> episodes = service.findAllEpisodes();
		StepVerifier.create(episodes)
		.assertNext(episode -> {
			assertEquals(1, episode.getId());
			assertEquals("Episode 1", episode.getName());
			assertEquals(Duration.ofMinutes(45), episode.getDuration());
			assertEquals(new Date("2022/10/10"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(2, episode.getId());
			assertEquals("Episode 2", episode.getName());
			assertEquals(Duration.ofMinutes(41), episode.getDuration());
			assertEquals(new Date("2022/10/11"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(3, episode.getId());
			assertEquals("Our History", episode.getName());
			assertEquals(Duration.ofMinutes(44), episode.getDuration());
			assertEquals(new Date("2022/02/01"), episode.getLaunchDate());
			assertEquals(2, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(4, episode.getId());
			assertEquals("Episode 4", episode.getName());
			assertEquals(Duration.ofMinutes(46), episode.getDuration());
			assertEquals(new Date("2022/10/12"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(5, episode.getId());
			assertEquals("The Last Breath", episode.getName());
			assertEquals(Duration.ofMinutes(42), episode.getDuration());
			assertEquals(new Date("2022/03/14"), episode.getLaunchDate());
			assertEquals(3, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(6, episode.getId());
			assertEquals("Episode 5", episode.getName());
			assertEquals(Duration.ofMinutes(50), episode.getDuration());
			assertEquals(new Date("2022/10/13"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.verifyComplete();
	}
	
	@Test
	public void findEpisodeById() {
		Mono<Episode> episode_ = service.findEpisodeById(4);
		StepVerifier.create(episode_)
		.assertNext(episode -> {
			assertEquals(4, episode.getId());
			assertEquals("Episode 4", episode.getName());
			assertEquals(Duration.ofMinutes(46), episode.getDuration());
			assertEquals(new Date("2022/10/12"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.verifyComplete();
	}
	
	@Test
	public void findEpisodeByName() {
		Flux<Episode> episode_ = service.findEpisodeByName("The Last Breath");
		StepVerifier.create(episode_)
		.assertNext(episode -> {
			assertEquals(5, episode.getId());
			assertEquals("The Last Breath", episode.getName());
			assertEquals(Duration.ofMinutes(42), episode.getDuration());
			assertEquals(new Date("2022/03/14"), episode.getLaunchDate());
			assertEquals(3, episode.getIdSeason());
		})
		.verifyComplete();
	}
	
	@Test
	public void findEpisodesBySeasonId() {
		Flux<Episode> episodes = service.findEpisodesBySeasonId(1);
		StepVerifier.create(episodes)
		.assertNext(episode -> {
			assertEquals(1, episode.getId());
			assertEquals("Episode 1", episode.getName());
			assertEquals(Duration.ofMinutes(45), episode.getDuration());
			assertEquals(new Date("2022/10/10"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(2, episode.getId());
			assertEquals("Episode 2", episode.getName());
			assertEquals(Duration.ofMinutes(41), episode.getDuration());
			assertEquals(new Date("2022/10/11"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(4, episode.getId());
			assertEquals("Episode 4", episode.getName());
			assertEquals(Duration.ofMinutes(46), episode.getDuration());
			assertEquals(new Date("2022/10/12"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.assertNext(episode -> {
			assertEquals(6, episode.getId());
			assertEquals("Episode 5", episode.getName());
			assertEquals(Duration.ofMinutes(50), episode.getDuration());
			assertEquals(new Date("2022/10/13"), episode.getLaunchDate());
			assertEquals(1, episode.getIdSeason());
		})
		.verifyComplete();
	}

}
