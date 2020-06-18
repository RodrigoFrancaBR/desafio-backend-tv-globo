package br.com.franca.dominio.vo.v1;

import java.sql.Timestamp;

import br.com.franca.dominio.enums.EstadoDaCena;

public class CenaVO {

	private Long id;
	private String nome;
	private EstadoDaCena estadoDaCena;
	private Timestamp dataDeAlteracao;	
	
	public CenaVO() {
	}

	public CenaVO(Long id, String nome, EstadoDaCena estadoDaCena) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadoDaCena = estadoDaCena;
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

	public EstadoDaCena getEstadoDaCena() {
		return estadoDaCena;
	}

	public void setEstadoDaCena(EstadoDaCena estadoDaCena) {
		this.estadoDaCena = estadoDaCena;
	}

	public Timestamp getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Timestamp dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	

}
