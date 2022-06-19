package br.ufrn.programacaoreativa.mvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
	private Date createdOn = new Date();
	
	private Date changedOn = new Date();
	
	@OneToMany(mappedBy = "usuario")
	private List<Cartao> cartoes;
	
	@OneToMany(mappedBy = "usuario")
	private List<Cobranca> cobranca;
	
	public User() {}

	public User(Integer id, String name, String email, String cpf, Date createdOn, Date changedOn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public List<Cobranca> getCobranca() {
		return cobranca;
	}

	public void setCobranca(List<Cobranca> cobranca) {
		this.cobranca = cobranca;
	}	

}

