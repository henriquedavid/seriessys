package br.ufrn.programacaoreativa.user.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Usuario {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
	private LocalDateTime createdOn = LocalDateTime.now();
	
	private LocalDateTime changedOn = LocalDateTime.now();
	
	public Usuario() {}

	public Usuario(Integer id, String name, String email, String cpf, LocalDateTime createdOn, LocalDateTime changedOn) {
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(LocalDateTime changedOn) {
		this.changedOn = changedOn;
	}
	
	

}
