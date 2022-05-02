package partybox.services;

import java.util.Arrays;

import partybox.model.Type;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TypeService {
	
	public Flux<Type> getTypes(){
		return Flux.fromIterable(Arrays.asList(
				new Type(1, "Serie"),
				new Type(2, "Film"),
				new Type(3, "Documentary")
				));
	}
	
	public Mono<Type> getTypeById(int idType){
		return getTypes().filterWhen(type -> Mono.just(type.getId() == idType)).last();
	}
	
	public Mono<Type> getTypeByName(String name){
		return getTypes().filterWhen(type_ -> Mono.just(type_.getName().equals(name))).last();
	}

}
