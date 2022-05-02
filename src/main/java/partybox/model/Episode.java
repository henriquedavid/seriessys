package partybox.model;

import java.time.Duration;
import java.util.Date;

public class Episode {
	
	private int id;
	private String name;
	private Duration duration;
	private Date launchDate;
	private int idSeason;
	
	public Episode(int id, String name, Duration duration, Date launchDate, int idSeason) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.launchDate = launchDate;
		this.idSeason = idSeason;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	public int getIdSeason() {
		return idSeason;
	}
	public void setIdSeason(int idSeason) {
		this.idSeason = idSeason;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + ", duration=" + duration + ", launchDate=" + launchDate
				+ ", idSeason=" + idSeason + "]";
	}
	
	

}
