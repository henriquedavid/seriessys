package partybox.model;

import java.util.ArrayList;
import java.util.List;

public class Season {
	
	private int id;
	private String name;
	private int idContent;
	private List<Episode> episodes;
	
	
	
	public Season(int id, String name, int idContent) {
		super();
		this.id = id;
		this.name = name;
		this.idContent = idContent;
		this.episodes = new ArrayList<Episode>();
	}

	public Season(int id, String name, int idContent, List<Episode> episodes) {
		super();
		this.id = id;
		this.name = name;
		this.idContent = idContent;
		this.episodes = episodes;
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
	public int getIdContent() {
		return idContent;
	}
	public void setIdContent(int idContent) {
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
