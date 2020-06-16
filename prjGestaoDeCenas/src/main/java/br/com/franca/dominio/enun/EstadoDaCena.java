package br.com.franca.dominio.enun;

import java.util.Arrays;

public enum EstadoDaCena {
	PENDENTE("Pendente"), PREPARADA("Preparada"), PENDURADA("Gravada"), GRAVADA("Gravada"), INVALIDO("Inválido");

	private String estado;

	private EstadoDaCena(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
	
	public EstadoDaCena obterEstadoDaCenaPorEstadoo(String estado) {
		return Arrays.asList(EstadoDaCena.values()).parallelStream().filter(e -> e.getEstado() == estado).findFirst()
				.orElse(EstadoDaCena.INVALIDO);
	}	
}
