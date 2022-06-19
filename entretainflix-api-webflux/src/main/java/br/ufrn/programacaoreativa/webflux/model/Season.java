package br.ufrn.programacaoreativa.webflux.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long idContent;
	private List<Episode> episodes;
	
	
	
	public Season(Long id, String name, Long idContent) {
		super();
		this.id = id;
		this.name = name;
		this.idContent = idContent;
		this.episodes = new ArrayList<Episode>();
	}

	public Season(Long id, String name, Long idContent, List<Episode> episodes) {
		super();
		this.id = id;
		this.name = name;
		this.idContent = idContent;
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
	public Long getIdContent() {
		return idContent;
	}
	public void setIdContent(Long idContent) {
		this.idContent = idContent;
	}
	public List<Episode> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + ", idContent=" + idContent + ", episodes=" + episodes + "]";
	}
	
	
	
}
