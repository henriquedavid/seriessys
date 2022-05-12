package partybox.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import partybox.model.Type;
import partybox.services.TypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TypeServiceTest {
	
	private TypeService service = new TypeService();
	
	@Test
	public void getTypes() {
		Flux<Type> types = service.getTypes();
		StepVerifier.create(types)
					.assertNext(type -> {
						assertEquals(1, type.getId());
						assertEquals("Serie", type.getName());
					})
					.assertNext(type -> {
						assertEquals(2, type.getId());
						assertEquals("Film", type.getName());
					})
					.assertNext(type -> {
						assertEquals(3, type.getId());
						assertEquals("Documentary", type.getName());
					})
					.verifyComplete();
	}
	
	@Test
	public void getTypeById() {
		Mono<Type> item = service.getTypeById(2);
		StepVerifier.create(item)
					.assertNext(type -> {
						assertEquals(2, type.getId());
						assertEquals("Film", type.getName());
					})
					.verifyComplete();
	}
	
	@Test
	public void getTypeByName() {
		Mono<Type> item = service.getTypeByName("Documentary");
		StepVerifier.create(item)
		.assertNext(type-> {
			assertEquals(3, type.getId());
			assertEquals("Documentary", type.getName());
		})
		.verifyComplete();
	}

}
