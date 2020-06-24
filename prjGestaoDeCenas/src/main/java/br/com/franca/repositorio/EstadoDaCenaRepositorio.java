package br.com.franca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.EstadoDaCena;

@Repository
public interface EstadoDaCenaRepositorio extends JpaRepository<EstadoDaCena, Long> {

	List<EstadoDaCena> findByCena(Cena cenaAtual);
}
