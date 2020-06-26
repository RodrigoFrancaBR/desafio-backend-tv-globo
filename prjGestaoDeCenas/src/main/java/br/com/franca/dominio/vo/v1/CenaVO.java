package br.com.franca.dominio.vo.v1;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.franca.dominio.enums.Estado;

public class CenaVO implements Serializable{

	private static final long serialVersionUID = 2141716828445711844L;
	private Long id;
	private String nomeDaCena;
	private Estado nomeDoEstado;
	private LocalDateTime dataInformada;

	public CenaVO() {
	}

	public CenaVO(Long id, String nomeDaCena, Estado nomeDoEstado, LocalDateTime dataInformada) {
		this.id = id;
		this.nomeDaCena = nomeDaCena;
		this.nomeDoEstado = nomeDoEstado;
		this.dataInformada = dataInformada;
	}

	public CenaVO(Long id, String nomeDaCena, Estado nomeDoEstado) {
		this.id = id;
		this.nomeDaCena = nomeDaCena;
		this.nomeDoEstado = nomeDoEstado;
	}

	public CenaVO(Long id, Estado nomeDoEstado, LocalDateTime dataInformada) {
		this.id = id;
		this.nomeDoEstado = nomeDoEstado;
		this.dataInformada = dataInformada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaCena() {
		return nomeDaCena;
	}

	public void setNomeDaCena(String nomeDaCena) {
		this.nomeDaCena = nomeDaCena;
	}

	public Estado getNomeDoEstado() {
		return nomeDoEstado;
	}

	public void setNomeDoEstado(Estado nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}

	public LocalDateTime getDataInformada() {
		return dataInformada;
	}

	public void setDataInformada(LocalDateTime dataInformada) {
		this.dataInformada = dataInformada;
	}

}
