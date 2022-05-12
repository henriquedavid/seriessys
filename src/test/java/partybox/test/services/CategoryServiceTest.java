package partybox.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import partybox.model.Category;
import partybox.services.CategoryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class CategoryServiceTest {
	
	private CategoryService service = new CategoryService();
	
	@Test
	public void getAllCategory() {
		Flux<Category> categorias = service.getAllCategory();
		StepVerifier.create(categorias)
		.assertNext(category -> {
			assertEquals(1, category.getId());
			assertEquals("Suspense", category.getNome());
		})
		.assertNext(category -> {
			assertEquals(2, category.getId());
			assertEquals("Ação", category.getNome());
		})
		.assertNext(category -> {
			assertEquals(3, category.getId());
			assertEquals("Aventura", category.getNome());
		})
		.assertNext(category -> {
			assertEquals(4, category.getId());
			assertEquals("Terror", category.getNome());
		})
		.assertNext(category -> {
			assertEquals(5, category.getId());
			assertEquals("Comédia", category.getNome());
		})
		.assertNext(category -> {
			assertEquals(6, category.getId());
			assertEquals("Romance", category.getNome());
		})
		.verifyComplete();
	}
	
	@Test
	public void getCategoryById() {
		Mono<Category> category = service.getCategoryById(2);
		StepVerifier.create(category)
		.assertNext(category_ -> {
			assertEquals(2, category_.getId());
			assertEquals("Ação", category_.getNome());
		})
		.verifyComplete();
	}
	
	@Test
	public void getCategoryByName() {
		Mono<Category> category = service.getCategoryByName("Terror");
		StepVerifier.create(category)
		.assertNext(category_ -> {
			assertEquals(4, category_.getId());
			assertEquals("Terror", category_.getNome());
		})
		.verifyComplete();
	}
	
	
	
}
