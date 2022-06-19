package br.ufrn.programacaoreativa.mvc.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.ufrn.programacaoreativa.mvc.model.Content;
import br.ufrn.programacaoreativa.mvc.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	ContentService service;
	
	@GetMapping
	public ResponseEntity<List<Content>> getAllContent(){
		return ResponseEntity.ok(service.getAllContent());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Content> getContentById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.getContentById(id));
	}
	
	@PostMapping
	public ResponseEntity<Content> createContent(@RequestBody Content content){
		return ResponseEntity.ok(service.addContent(content));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Content> updateContent(@PathVariable("id") Long contentId, @RequestBody Content content){
		return  ResponseEntity.ok(service.updateContent(contentId, content));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Content> deleteContent(@PathVariable("id") Long contentId){
		return ResponseEntity.ok(service.deleteContent(contentId));
	}

}
