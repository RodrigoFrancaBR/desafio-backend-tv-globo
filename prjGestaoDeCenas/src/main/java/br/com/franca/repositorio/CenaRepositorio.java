package br.com.franca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.dominio.Cena;

@Repository
public interface CenaRepositorio extends JpaRepository<Cena, Long> {	

}
