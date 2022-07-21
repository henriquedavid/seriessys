package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Category {
	@Id
	private Long id;
	private String nome;
	
	public Category() {}
	
	public Category(Long i, String nome) {
		super();
		this.id = i;
		this.nome = nome;
	}

	public Category(Long id, String nome, ArrayList<Content> content) {
		super();
		this.id = id;
		this.nome = nome;
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


}
