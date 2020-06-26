package br.com.franca.dominio.vo.v1;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.franca.dominio.enums.Estado;
import br.com.franca.dominio.enums.TipoDaOperacao;

public class EstadoDaCenaVO implements Serializable{

	private static final long serialVersionUID = -7752224974266548314L;
	// private Long id;
	private Long idDaCena;
	private String nomeDaCena;
	private String nomeDaOperacao;
	private LocalDateTime dataDaOperacao;
	private String nomeDoEstado;
	private LocalDateTime dataInformada;
		
	// private Cena cena;
	
		

	public EstadoDaCenaVO(
			Estado nomeDoEstado,
			LocalDateTime dataInformada,
			LocalDateTime dataDaOperacao,
			TipoDaOperacao nomeDaOperacao,
			Long idDaCena,
			String nomeDaCena
			//Cena cena
			) {
		this.nomeDoEstado = nomeDoEstado.getValor();
		this.dataInformada = dataInformada;
		this.dataDaOperacao = dataDaOperacao;
		this.nomeDaOperacao = nomeDaOperacao.getValor();
		this.idDaCena = idDaCena;
		this.nomeDaCena = nomeDaCena;
		// this.cena = cena;
	}
	
	public EstadoDaCenaVO() {	
	}
/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/
	
	public Estado getNomeDoEstado() {
		return Estado.obterEstadoDaCenaPorValor(nomeDoEstado);
	}

	public void setNomeDoEstado(Estado nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado.getValor();
	}

	public LocalDateTime getDataInformada() {
		return dataInformada;
	}

	public void setDataInformada(LocalDateTime dataInformada) {
		this.dataInformada = dataInformada;
	}

	public LocalDateTime getDataDaOperacao() {
		return dataDaOperacao;
	}

	public void setDataDaOperacao(LocalDateTime dataDaOperacao) {
		this.dataDaOperacao = dataDaOperacao;
	}	

	public TipoDaOperacao getNomeDaOperacao() {
		return TipoDaOperacao.obterTipoDaOperacaoPorValor(nomeDaOperacao);
	}

	public void setNomeDaOperacao(TipoDaOperacao nomeDaOperacao) {
		this.nomeDaOperacao = nomeDaOperacao.getValor();
	}

	public Long getIdDaCena() {
		return idDaCena;
	}

	public void setIdDaCena(Long idDaCena) {
		this.idDaCena = idDaCena;
	}

	public String getNomeDaCena() {
		return nomeDaCena;
	}

	public void setNomeDaCena(String nomeDaCena) {
		this.nomeDaCena = nomeDaCena;
	}	

/*	public Cena getCena() {
		return cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}*/

}
