package br.ufrn.programacaoreativa.webflux.model;

public class MensagemDTO {

	private Integer idcontent;
	private String mensagem;
	
	public MensagemDTO() {
		super();
	}
	public MensagemDTO(Integer idcontent, String mensagem) {
		super();
		this.idcontent = idcontent;
		this.mensagem = mensagem;
	}
	public Integer getIdcontent() {
		return idcontent;
	}
	public void setIdcontent(Integer idcontent) {
		this.idcontent = idcontent;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
