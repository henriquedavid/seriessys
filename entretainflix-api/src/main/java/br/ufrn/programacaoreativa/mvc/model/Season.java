package br.ufrn.programacaoreativa.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Season {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="content_id", nullable=false)
	private Content content;
	
	@JsonIgnore
	@OneToMany(mappedBy = "season")
	private List<Episode> episodes;
	
	public Season() {}
	
	
	public Season(Long id, String name, Content content, List<Episode> episodes) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.episodes = episodes;
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
	
	

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
