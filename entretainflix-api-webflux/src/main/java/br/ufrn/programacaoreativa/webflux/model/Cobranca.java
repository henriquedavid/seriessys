package br.ufrn.programacaoreativa.webflux.model;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Double valor;
	
	private Date dataefetivacao;

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
