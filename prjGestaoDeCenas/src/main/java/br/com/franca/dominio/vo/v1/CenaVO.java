package br.com.franca.dominio.vo.v1;

import java.time.LocalDateTime;

import br.com.franca.dominio.enums.Estado;

public class CenaVO {

	private Long id;
	private String nome;
	private Estado estado;
	private LocalDateTime dataDeAlteracao;

	public CenaVO() {
	}

	public CenaVO(Long cenaId, String nomeDaCena, Estado estado, LocalDateTime dataDeAlteracao) {
		this.id = cenaId;
		this.nome = nomeDaCena;
		this.estado = estado;
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public CenaVO(Long cenaId, String nomeDaCena, Estado estado) {
		this.id = cenaId;
		this.nome = nomeDaCena;
		this.estado = estado;
	}
	
	public CenaVO(Long cenaId, Estado estado, LocalDateTime dataDeAlteracao) {
		this.id = cenaId;		
		this.estado = estado;
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDateTime getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(LocalDateTime dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

}
