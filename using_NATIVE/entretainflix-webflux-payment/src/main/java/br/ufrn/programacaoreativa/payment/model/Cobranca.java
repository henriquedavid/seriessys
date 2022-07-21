package br.ufrn.programacaoreativa.payment.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Cobranca {
	
	@Id
	private Integer id;
	
	private Integer usuario;
	
	private Integer episode;
	
	private LocalDateTime datapagamento;
	
	private String statusTransacao;
	

	public Cobranca() {
		super();
	}

	public Cobranca(Integer id, Integer usuario, Integer episode, LocalDateTime datapagamento, String statusTransacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.episode = episode;
		this.datapagamento = datapagamento;
		this.statusTransacao = statusTransacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(LocalDateTime datapagamento) {
		this.datapagamento = datapagamento;
	}

	public String getStatusTransacao() {
		return statusTransacao;
	}

	public void setStatusTransacao(String statusTransacao) {
		this.statusTransacao = statusTransacao;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}
	

}
