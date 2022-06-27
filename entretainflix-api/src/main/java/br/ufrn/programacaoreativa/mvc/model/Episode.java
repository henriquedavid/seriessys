package br.ufrn.programacaoreativa.mvc.model;

import java.time.Duration;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Episode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long duration;
	private Date launchDate;
	
	@ManyToOne
	@JoinColumn(name="episode_id", nullable=false)
	private Season season;
	
	public Episode() {}
	
	
	
	public Episode(Long id, String name, Long duration, Date launchDate, Season season) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.launchDate = launchDate;
		this.season = season;
	}



	public Episode(Long id, String name, Long duration, Date launchDate) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.launchDate = launchDate;
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
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	
	

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + ", duration=" + duration + ", launchDate=" + launchDate
				+ "]";
	}
	
	

}
