package br.ufrn.programacaoreativa.mvc.model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToMany(mappedBy="categories")
	private Set<Content> contents; 

	public Category() {
		super();
	}

	public Category(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public Category(Long id, String nome, Set<Content> contents) {
		super();
		this.id = id;
		this.nome = nome;
		this.contents = contents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}
	
	

}
