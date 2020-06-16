package br.com.franca.servico;

import org.springframework.stereotype.Service;

import br.com.franca.dominio.Cena;
import br.com.franca.repositorio.CenaRepositorio;

@Service
public class CenaServico {

	private CenaRepositorio repositorio;

	public CenaServico(CenaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public void apagarTodasAsCenas() {
		repositorio.deleteAll();
	}

	public Cena gravarCena(Cena cena) {
		return repositorio.save(cena);
	}

}