package br.com.franca.dominio.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Estado {

	PENDENTE("Pendente") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return novoEstado.equals(Estado.PREPARADA.getValor()) || novoEstado.equals(Estado.PENDURADA.getValor()) ? true : false;
		}

		@Override
		public boolean permiteDesfazerAlteracaoDeEstado(String novoEstado) {
			return false;
		}

	},

	PREPARADA("Preparada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return novoEstado.equals(Estado.GRAVADA.getValor()) || novoEstado.equals(Estado.PENDURADA.getValor()) ? true: false;
		}

		@Override
		public boolean permiteDesfazerAlteracaoDeEstado(String novoEstado) {
			return novoEstado.equals(Estado.PENDENTE.getValor()) ? true : false;
		}
	},

	PENDURADA("Pendurada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return false;
		}

		@Override
		public boolean permiteDesfazerAlteracaoDeEstado(String novoEstado) {
			return novoEstado.equals(Estado.PREPARADA.getValor()) ? true : false;
		}
	},

	GRAVADA("Gravada") {
		@Override
		public boolean permiteAlterarEstadoDaCenaPara(String novoEstado) {
			return false;
		}

		@Override
		public boolean permiteDesfazerAlteracaoDeEstado(String novoEstado) {
			return novoEstado.equals(Estado.PREPARADA.getValor()) ? true : false;
		}
	};

	public static Estado obterEstadoDaCenaPorValor(String valor) {
		return Arrays.asList(Estado.values()).parallelStream().filter(e -> e.getValor() == valor)
				.collect(Collectors.toList()).get(0);
	}

	private String valor;

	private Estado(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public abstract boolean permiteAlterarEstadoDaCenaPara(String novoEstado);

	public abstract boolean permiteDesfazerAlteracaoDeEstado(String novoEstado);

}
