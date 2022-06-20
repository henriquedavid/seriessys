package br.ufrn.programacaoreativa.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="type_id", nullable=false)
	private Type type;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="category_like", 
				joinColumns = @JoinColumn(name="content_id"),
				inverseJoinColumns = @JoinColumn(name="category_id"))
	private Set<Category> categories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "content")
	private List<Season> seasons;
	
	public Content() {
		super();
	}

	public Content(Long id, String name, Type type, Set<Category> categories, List<Season> seasons) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.categories = categories;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
