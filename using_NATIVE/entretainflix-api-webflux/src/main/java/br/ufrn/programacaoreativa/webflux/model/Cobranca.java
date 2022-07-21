package br.ufrn.programacaoreativa.webflux.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Cobranca {
	
	@Id
	private Integer id;
	
	private Double valor;
	
	private Date dataefetivacao;
	
	public Cobranca() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataefetivacao() {
		return dataefetivacao;
	}

	public void setDataefetivacao(Date dataefetivacao) {
		this.dataefetivacao = dataefetivacao;
	}
	
	
	

}
