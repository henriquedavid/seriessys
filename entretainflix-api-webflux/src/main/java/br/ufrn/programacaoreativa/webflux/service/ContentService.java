package br.ufrn.programacaoreativa.webflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.programacaoreativa.webflux.model.Content;
import br.ufrn.programacaoreativa.webflux.repository.ContentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContentService {
	
	@Autowired
	private ContentRepository repository;
	
	public Flux<Content> getAllContent(){
		return repository.findAll();
	}
	
	public Mono<Content> getContentById(Long id) {
		return repository.findById(id);
	}
	
	public Mono<Content> addContent(Content content) {
		return repository.save(content);
	}
	
	public Mono<Content> updateContent(Long contentId, Content content) {
		return repository.save(content);
	}
	
	public Mono<Void> deleteContent(Long contentId) {
		return repository.deleteById(contentId);
	}

}
