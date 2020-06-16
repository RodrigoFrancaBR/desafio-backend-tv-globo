package br.com.franca.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.franca.dominio.enun.EstadoDaCena;

@Entity
@Table(name="TB_CENA")
public class Cena {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cena")
	private String nomeDaCena;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_cena")
	private EstadoDaCena estadoDaCena;

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
		return estadoDaCena;
	}

	public void setEstadoDaCena(EstadoDaCena estadoDaCena) {
		this.estadoDaCena = estadoDaCena;
	}	
	
}
