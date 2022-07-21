package br.ufrn.programacaoreativa.payment.model;

import java.time.LocalDateTime;
import java.util.Date;

public class ReciboDTO {
	
	private Integer idUser;
	private Double valor;
	private LocalDateTime data;
	
	public ReciboDTO(Integer idUser, Double valor, LocalDateTime data) {
		super();
		this.idUser = idUser;
		this.valor = valor;
		this.data = data;
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
