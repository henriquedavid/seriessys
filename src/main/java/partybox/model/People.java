package partybox.model;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Mono;

public class People extends BaseSubscriber<Series>{
	
	String nome;
	private Subscription subscription;
	
	public People(String nome) {
		super();
		this.nome = nome;
	}

	public Mono<String> getNome() {
		return Mono.just(nome);
	}
	
//	@Override
//	public void hookOnSubscribe(Subscription subscrition) {
//		this.subscription = subscrition;
//		System.out.println("SE subs");
//		request(1);
//	}
//	
//	@Override
//	public void hookOnNext(Event value) {
//		System.out.println("Passou pelo aqui");
//		request(1);
//	}
//	
}
