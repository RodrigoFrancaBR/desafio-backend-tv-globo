package br.com.franca.servico;

import org.springframework.stereotype.Service;

import br.com.franca.dominio.EstadoDaCena;
import br.com.franca.repositorio.EstadoDaCenaRepositorio;

@Service
public class EstadoDaCenaServico {
	
	private EstadoDaCenaRepositorio repositorio;

	public EstadoDaCenaServico(EstadoDaCenaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	public EstadoDaCena gravarEstadoDaCena(EstadoDaCena estadoDaCena) {
		return repositorio.save(estadoDaCena);
	}

}
