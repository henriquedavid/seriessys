package br.ufrn.programacaoreativa.mvc.model.dto;

public class DadosPagamentoDTO {
	
	private Integer userId;
	
	private Long episodeId;
	
	private Double valor;
	
	

	public DadosPagamentoDTO(Integer userId, Long long1, Double valor) {
		super();
		this.userId = userId;
		this.episodeId = long1;
		this.valor = valor;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Long episodeId) {
		this.episodeId = episodeId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
