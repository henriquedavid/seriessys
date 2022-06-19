package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long idType;
	private Long idCategory;
	private List<Season> seasons;
	
	public Content(Long id, String name, Long idType, Long idCategory) {
		super();
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.idCategory = idCategory;
		this.seasons = new ArrayList<Season>();
	}
	
	public Content(Content c) {
		super();
		this.id = c.getId();
		this.idCategory = c.getIdCategory();
		this.idType = c.getIdType();
		this.name = c.getName();
		this.seasons = c.getSeasons();
	}
	
	
	public Content(Long id, String name, Long idType, Long idCategory, List<Season> seasons) {
		super();
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.idCategory = idCategory;
		this.seasons = seasons;
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


	public List<Season> getSeasons() {
		return seasons;
	}


	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}


	@Override
	public String toString() {
		return "Content [id=" + id + ", name=" + name + ", idType=" + idType + ", idCategory=" + idCategory
				+ ", seasons=" + seasons.toString() + "]";
	}
	
	
	

}
