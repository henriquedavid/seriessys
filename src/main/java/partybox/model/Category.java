package partybox.model;

import java.util.ArrayList;

import reactor.core.publisher.Flux;

public class Category {
	
	private int id;
	private String nome;
	private ArrayList<Series> series;
	
	public Category(int i, String nome) {
		super();
		this.id = i;
		this.nome = nome;
		this.series = new ArrayList<Series>();
	}

	public Category(int id, String nome, ArrayList<Series> series) {
		super();
		this.id = id;
		this.nome = nome;
		this.series = series;
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

	public ArrayList<Series> getSeries() {
		return series;
	}

	public void setSeries(ArrayList<Series> series) {
		this.series = series;
	}
	
	

}
