package br.ufrn.programacaoreativa.mvc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String apelido;
	
	private String numero;
	
	private String cvv;
	
	private String nomeNoCartao;
	
	private Date vencimento;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User usuario;
	
	public Cartao() {}

	public Cartao(Integer id, String apelido, String numero, String cvv, String nomeNoCartao, Date vencimento) {
		super();
		this.id = id;
		this.apelido = apelido;
		this.numero = numero;
		this.cvv = cvv;
		this.nomeNoCartao = nomeNoCartao;
		this.vencimento = vencimento;
	}
	
	

	public Cartao(Integer id, String apelido, String numero, String cvv, String nomeNoCartao, Date vencimento,
			User usuario) {
		super();
		this.id = id;
		this.apelido = apelido;
		this.numero = numero;
		this.cvv = cvv;
		this.nomeNoCartao = nomeNoCartao;
		this.vencimento = vencimento;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNomeNoCartao() {
		return nomeNoCartao;
	}

	public void setNomeNoCartao(String nomeNoCartao) {
		this.nomeNoCartao = nomeNoCartao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
