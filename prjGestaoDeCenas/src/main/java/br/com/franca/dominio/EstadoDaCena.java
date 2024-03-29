package br.com.franca.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.franca.dominio.enums.Estado;
import br.com.franca.dominio.enums.TipoDaOperacao;

@Entity
@Table(name = "tb_estado_cena")
public class EstadoDaCena implements Serializable {

	private static final long serialVersionUID = -2696475215300863472L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nm_estado")
	private String nomeDoEstado;

	@Column(name = "dt_informada")
	private LocalDateTime dataInformada;

	@Column(name = "dt_operacao")
	private LocalDateTime dataDaOperacao;
	
	@Column(name = "nm_operacao")
	private String nomeDaOperacao;

	@ManyToOne
	@JoinColumn(name = "id_cena")
	private Cena cena;

	public EstadoDaCena(Estado nomeDoEstado,
			LocalDateTime dataInformada,
			LocalDateTime dataDaOperacao,
			Cena cena) {
		this.nomeDoEstado = nomeDoEstado.getValor();
		this.dataInformada = dataInformada;
		this.dataDaOperacao = dataDaOperacao;
		this.cena = cena;
	}

	public EstadoDaCena() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	public Cena getCena() {
		return cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoDaCena other = (EstadoDaCena) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadoDaCena [id=" + id + ", nomeDoEstado=" + nomeDoEstado + ", dataInformada=" + dataInformada
				+ ", dataDaOperacao=" + dataDaOperacao + ", cena=" + cena + "]";
	}

}
