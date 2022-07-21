package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;

public class Season {
	@Id
	private Long id;
	private String name;
	private Long idContent;
	
	public Season() {}
	
	public Season(Long id, String name, Long idContent) {
		super();
		this.id = id;
		this.name = name;
		this.idContent = idContent;
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
	public Long getIdContent() {
		return idContent;
	}
	public void setIdContent(Long idContent) {
		this.idContent = idContent;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + ", idContent=" + idContent + "]";
	}
	
	
	
}
