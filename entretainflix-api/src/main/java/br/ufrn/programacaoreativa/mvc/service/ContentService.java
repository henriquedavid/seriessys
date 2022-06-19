package br.ufrn.programacaoreativa.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufrn.programacaoreativa.mvc.model.Content;
import br.ufrn.programacaoreativa.mvc.repository.ContentRepository;

@Service
public class ContentService {
	
	@Autowired
	ContentRepository repository;
	
	public List<Content> getAllContent(){
		return repository.findAll();
	}
	
	public Content getContentById(Long id) {
		Optional<Content> content_ = repository.findById(id);
		if(content_.isPresent())
			return content_.get();
		else
			return null;
	}
	
	public Content addContent(Content content) {
		return repository.save(content);
	}
	
	public Content updateContent(Long contentId, Content content) {
		if(repository.findById(contentId).isPresent()) {
			content.setId(contentId);
			return repository.save(content);
		} else {
			return null;
		}
	}
	
	public Content deleteContent(Long contentId) {
		Optional<Content> content_ = repository.findById(contentId);
		if(content_.isPresent()) {
			repository.deleteById(contentId);
			return content_.get();
		} else {
			return null;
		}
	}

}
