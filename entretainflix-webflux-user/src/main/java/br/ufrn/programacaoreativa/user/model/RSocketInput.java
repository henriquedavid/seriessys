package br.ufrn.programacaoreativa.user.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RSocketInput {
	
	private String origin;
	private String interaction;
	private Integer id;
	private long created = Instant.now().getEpochSecond();
	
	public RSocketInput(String origin, String interaction) {
		super();
		this.origin = origin;
		this.interaction = interaction;
	}

	public RSocketInput(String origin, String interaction, Integer id) {
		super();
		this.origin = origin;
		this.interaction = interaction;
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getInteraction() {
		return interaction;
	}

	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	
	

}
