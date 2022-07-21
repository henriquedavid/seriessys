package br.ufrn.programacaoreativa.webflux.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Episode {
	@Id
	private Long id;
	private String name;
	private Long duration;
//	private LocalDateTime launchDate;
	@Column(value = "episode_id")
	private Long idSeason;
	
	public Episode() {}
	
	public Episode(Long id, String name, Long duration, Long idSeason) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.idSeason = idSeason;
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
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getIdSeason() {
		return idSeason;
	}
	public void setIdSeason(Long idSeason) {
		this.idSeason = idSeason;
		
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + ", duration=" + duration
				+ ", idSeason=" + idSeason + "]";
	}
	
	

}
