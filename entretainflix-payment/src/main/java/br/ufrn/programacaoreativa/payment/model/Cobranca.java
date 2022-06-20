package br.ufrn.programacaoreativa.payment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cobranca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private Integer usuario;
	
	private Integer episode;
	
	private Date datapagamento;
	
	private String statusTransacao;
	

	public Cobranca() {
		super();
	}

	public Cobranca(Integer id, Integer usuario, Integer episode, Date datapagamento, String statusTransacao) {
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

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
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
