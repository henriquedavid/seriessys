package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private ArrayList<Content> content;
	
	public Category(Long i, String nome) {
		super();
		this.id = i;
		this.nome = nome;
		this.content = new ArrayList<Content>();
	}

	public Category(Long id, String nome, ArrayList<Content> content) {
		super();
		this.id = id;
		this.nome = nome;
		this.content = content;
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

	public ArrayList<Content> getContent() {
		return content;
	}

	public void setContent(ArrayList<Content> content) {
		this.content = content;
	}


}
