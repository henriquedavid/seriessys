package partybox.model;

import java.util.ArrayList;

import reactor.core.publisher.Flux;

public class Category {
	
	private int id;
	private String nome;
	private ArrayList<Content> content;
	
	public Category(int i, String nome) {
		super();
		this.id = i;
		this.nome = nome;
		this.content = new ArrayList<Content>();
	}

	public Category(int id, String nome, ArrayList<Content> content) {
		super();
		this.id = id;
		this.nome = nome;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
