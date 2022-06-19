package br.ufrn.programacaoreativa.mvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanosAssinatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Double valor;
	
	private Date createdOn = new Date();
	
	private Date changedOn = new Date();
	
	public PlanosAssinatura() {}

	public PlanosAssinatura(Integer id, String name, Double valor) {
		super();
		this.id = id;
		this.name = name;
		this.valor = valor;
	}

	public PlanosAssinatura(Integer id, String name, Double valor, Date createdOn, Date changedOn) {
		super();
		this.id = id;
		this.name = name;
		this.valor = valor;
		this.createdOn = createdOn;
		this.changedOn = changedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}
	
	

}
