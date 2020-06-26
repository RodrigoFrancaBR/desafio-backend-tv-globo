package br.com.franca.dominio.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum TipoDaOperacao {
	ALTERAR("Alterar"), DESFAZER("Desfazer");

	private String valor;

	private TipoDaOperacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public static TipoDaOperacao obterTipoDaOperacaoPorValor(String valor) {
		return Arrays.asList(TipoDaOperacao.values()).parallelStream().filter(e -> e.getValor() == valor)
				.collect(Collectors.toList()).get(0);
	}
}
