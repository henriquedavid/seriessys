package br.ufrn.programacaoreativa.mvc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "type")
	private Set<Content> content;

	public Type() {
		super();
	}

	public Type(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Type(Long id, String name, Set<Content> content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Set<Content> getContent() {
		return content;
	}



	public void setContent(Set<Content> content) {
		this.content = content;
	}
	
	
	
}
