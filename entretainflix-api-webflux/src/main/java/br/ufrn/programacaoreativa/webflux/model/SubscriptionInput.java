package br.ufrn.programacaoreativa.webflux.model;

public class SubscriptionInput {
	
	private String nome;
	private String email;
	
	public SubscriptionInput() {}
	public SubscriptionInput(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String input) {
		this.nome = input;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
