package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Content {
	@Id
	private Long id;
	private String name;
	private Long idType;
	private Long idCategory;
	
	public Content() {}
	
	public Content(Long id, String name, Long idType, Long idCategory) {
		super();
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.idCategory = idCategory;
	}
	
	public Content(Content c) {
		super();
		this.id = c.getId();
		this.idCategory = c.getIdCategory();
		this.idType = c.getIdType();
		this.name = c.getName();
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
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	@Override
	public String toString() {
		return "Content [id=" + id + ", name=" + name + ", idType=" + idType + ", idCategory=" + idCategory
				+ "]";
	}
	
	
	

}
