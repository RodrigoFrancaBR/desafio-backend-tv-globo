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

@Entity
@Table(name = "tb_estado_cena")
public class EstadoDaCena implements Serializable {

	private static final long serialVersionUID = -2696475215300863472L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "estado_cena")
	private String estado;

	@Column(name = "dt_alteracao")
	private LocalDateTime dataDeAlteracao;

	@ManyToOne
	@JoinColumn(name = "cena_id")
	private Cena cena;

	public EstadoDaCena( Estado estado, LocalDateTime dataDeAlteracao, Cena cena) {
		this.estado = estado.getValor();
		this.dataDeAlteracao = dataDeAlteracao;
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

	public LocalDateTime getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(LocalDateTime dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public Estado getEstadoDaCena() {
		return Estado.obterEstadoDaCenaPorValor(estado);
	}

	public void setEstadoDaCena(Estado estado) {
		this.estado = estado.getValor();
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
		return "EstadoDaCena [id=" + id + ", dataDeAlteracao=" + dataDeAlteracao + ", estadoDaCena=" + estado
				+ ", cena=" + cena + "]";
	}
}
