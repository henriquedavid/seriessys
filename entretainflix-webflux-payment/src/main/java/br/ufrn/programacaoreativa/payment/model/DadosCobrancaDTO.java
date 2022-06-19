package br.ufrn.programacaoreativa.payment.model;

import java.util.Date;

public class DadosCobrancaDTO {
	
	private Integer userId;
	
	private Integer episodeId;
	
	private Double valor;
	
	public DadosCobrancaDTO() {}

	public DadosCobrancaDTO(Integer userId, Integer episodeId, Double valor) {
		super();
		this.userId = userId;
		this.episodeId = episodeId;
		this.valor = valor;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Integer episodeId) {
		this.episodeId = episodeId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
