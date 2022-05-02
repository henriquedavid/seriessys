package partybox.model;

import java.util.ArrayList;
import java.util.List;

public class Content {
	
	private int id;
	private String name;
	private int idType;
	private int idCategory;
	private List<Season> seasons;
	
	public Content(int id, String name, int idType, int idCategory) {
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
	
	
	public Content(int id, String name, int idType, int idCategory, List<Season> seasons) {
		super();
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.idCategory = idCategory;
		this.seasons = seasons;
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
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
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
