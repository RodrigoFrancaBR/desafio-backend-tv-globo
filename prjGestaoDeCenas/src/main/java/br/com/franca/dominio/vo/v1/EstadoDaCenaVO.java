package br.com.franca.dominio.vo.v1;

import java.time.LocalDateTime;

import br.com.franca.dominio.Cena;

public class EstadoDaCenaVO {
	private Long id;
	private LocalDateTime dataDeAlteracao;
	private String estado;
	private Cena cena;

	public EstadoDaCenaVO() {
	}

	public EstadoDaCenaVO(Cena cena, String estado, LocalDateTime dataDeAlteracao) {
		super();
		this.cena = cena;
		this.estado = estado;
		this.dataDeAlteracao = dataDeAlteracao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(LocalDateTime dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cena getCena() {
		return cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}

}
