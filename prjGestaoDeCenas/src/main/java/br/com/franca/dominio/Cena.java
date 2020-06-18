package br.com.franca.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.franca.dominio.enums.EstadoDaCena;

@Entity
@Table(name = "TB_CENA")
public class Cena implements Serializable {
	private static final long serialVersionUID = -5793532401439768688L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_cena")
	private String nomeDaCena;

	@Column(name = "estado_cena")
	private String estadoDaCena;

	public Cena() {
	}

	public Cena(Long id, String nomeDaCena, EstadoDaCena estadoDaCena) {
		this.id = id;
		this.nomeDaCena = nomeDaCena;
		this.estadoDaCena = estadoDaCena.getValor();
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

	public EstadoDaCena getEstadoDaCena() {
		return EstadoDaCena.obterEstadoDaCenaPorValor(this.estadoDaCena);
		// return estadoDaCena;
	}

	public void setEstadoDaCena(EstadoDaCena estadoDaCena) {
		this.estadoDaCena = estadoDaCena.getValor();
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
		Cena other = (Cena) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
