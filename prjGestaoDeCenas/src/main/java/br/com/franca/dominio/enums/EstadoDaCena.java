package br.com.franca.dominio.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum EstadoDaCena {

	PENDENTE("Pendente") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return this.getValor().equals(EstadoDaCena.PENDENTE.getValor())
					&& novoEstado.equals(EstadoDaCena.PREPARADA.getValor())
					|| this.getValor().equals(EstadoDaCena.PENDENTE.getValor())
							&& novoEstado.equals(EstadoDaCena.PENDURADA.getValor()) ? true : false;
		}
	},

	PREPARADA("Preparada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return this.getValor().equals(EstadoDaCena.PREPARADA.getValor())
					&& novoEstado.equals(EstadoDaCena.GRAVADA.getValor())
					|| this.getValor().equals(EstadoDaCena.PREPARADA.getValor())
							&& novoEstado.equals(EstadoDaCena.PENDURADA.getValor()) ? true : false;
		}
	},

	PENDURADA("Pendurada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return false;
		}
	},

	GRAVADA("Gravada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return false;
		}
	};	

	public static EstadoDaCena obterEstadoDaCenaPorValor(String valor) {
		return Arrays.asList(EstadoDaCena.values()).parallelStream().filter(e -> e.getValor() == valor)
				.collect(Collectors.toList()).get(0);
	}
	
	private String valor;

	private EstadoDaCena(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}	

	public abstract boolean permiteAlterarEstadoDaCenaPara(String novoEstado);
	
}
