package br.com.franca.dominio.vo.v1;

import br.com.franca.dominio.enun.EstadoDaCena;

public class CenaVO {

	private Long id;
	private EstadoDaCena estadoDaCena;
	private String horarioDaAlteracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoDaCena getEstadoDaCena() {
		return estadoDaCena;
	}

	public void setEstadoDaCena(EstadoDaCena estadoDaCena) {
		this.estadoDaCena = estadoDaCena;
	}

	public String getHorarioDaAlteracao() {
		return horarioDaAlteracao;
	}

	public void setHorarioDaAlteracao(String horarioDaAlteracao) {
		this.horarioDaAlteracao = horarioDaAlteracao;
	}

}
