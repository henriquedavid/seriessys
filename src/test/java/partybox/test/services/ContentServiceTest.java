package partybox.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import partybox.model.Content;
import partybox.services.CategoryService;
import partybox.services.ContentService;
import partybox.services.EpisodeService;
import partybox.services.SeasonService;
import partybox.services.TypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ContentServiceTest {

	private CategoryService categoryService = new CategoryService();
	private TypeService typeService = new TypeService();
	private EpisodeService episodeService = new EpisodeService();
	private SeasonService seasonService = new SeasonService(episodeService);
	private ContentService service = new ContentService(categoryService, typeService, seasonService);
	
	
	@Test
	public void getContent() {
		Flux<Content> contents = service.getContent();
		StepVerifier.create(contents)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(2, content.getId());
			assertEquals("O Homem do Norte", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(3, content.getId());
			assertEquals("Thor: Amor e Trovão", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(4, content.getId());
			assertEquals("Top Gun: Maverick", content.getName());
			assertEquals(1, content.getIdType());
			assertEquals(1, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(5, content.getId());
			assertEquals("Jurassic World Domínio", content.getName());
			assertEquals(3, content.getIdType());
			assertEquals(4, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentById() {
		Mono<Content> content_ = service.getContentById(3);
		StepVerifier.create(content_)
		.assertNext(content -> {
			assertEquals(3, content.getId());
			assertEquals("Thor: Amor e Trovão", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getAllContent() {
		Flux<Content> contents = service.getContent();
		StepVerifier.create(contents)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(2, content.getId());
			assertEquals("O Homem do Norte", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(3, content.getId());
			assertEquals("Thor: Amor e Trovão", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(4, content.getId());
			assertEquals("Top Gun: Maverick", content.getName());
			assertEquals(1, content.getIdType());
			assertEquals(1, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(5, content.getId());
			assertEquals("Jurassic World Domínio", content.getName());
			assertEquals(3, content.getIdType());
			assertEquals(4, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentByIdComplete() {
		Mono<Content> content_ = service.getContentByIdComplete(2);
		StepVerifier.create(content_)
		.assertNext(content -> {
			assertEquals(2, content.getId());
			assertEquals("O Homem do Norte", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentByTypeName() {
		Flux<Content> contents = service.getContentByTypeName("Film");
		StepVerifier.create(contents)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(2, content.getId());
			assertEquals("O Homem do Norte", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(3, content.getId());
			assertEquals("Thor: Amor e Trovão", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentByCategoryName() {
		Flux<Content> content_ = service.getContentByCategoryName("Ação");
		StepVerifier.create(content_)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(2, content.getId());
			assertEquals("O Homem do Norte", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.assertNext(content -> {
			assertEquals(3, content.getId());
			assertEquals("Thor: Amor e Trovão", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentByName() {
		Mono<Content> content_ = service.getContentByName("Doutor Estranho no Multiverso da Loucura");
		StepVerifier.create(content_)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
	@Test
	public void getContentByNameError() {
		Mono<Content> content_ = service.getContentByName("Dr");
		StepVerifier.create(content_)
		.verifyError();
	}
	
	@Test
	public void getSearchNameContent() {
		Flux<Content> content_ = service.getSearchNameContent("Doutor Estranho");
		StepVerifier.create(content_)
		.assertNext(content -> {
			assertEquals(1, content.getId());
			assertEquals("Doutor Estranho no Multiverso da Loucura", content.getName());
			assertEquals(2, content.getIdType());
			assertEquals(2, content.getIdCategory());
		})
		.verifyComplete();
	}
	
}
