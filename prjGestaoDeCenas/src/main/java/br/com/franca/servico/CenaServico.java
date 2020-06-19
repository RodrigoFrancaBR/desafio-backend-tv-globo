package br.com.franca.servico;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.enums.EstadoDaCena;
import br.com.franca.dominio.vo.v1.CenaVO;
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

	public Cena buscarCenaPorId(Long id) throws Exception {
		return repositorio.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Não foi encontrada nenhuma cena para o ID informado "));
	}

	public void alterarEstadoDaCena(CenaVO cenaVO) throws Exception {

		if (cenaVO == null)
			throw new IllegalArgumentException("A nova cena não pode ser null");

		if (cenaVO.getEstadoDaCena() == null)
			throw new IllegalArgumentException("O estado da nova cena não pode ser null");

		if (cenaVO.getDataDeAlteracao() == null)
			throw new IllegalArgumentException("A dataDeAlteracao não pode ser null");
		
		if (cenaVO.getDataDeAlteracao().isAfter(LocalDateTime.now()))
			throw new IllegalArgumentException("A dataDeAlteracao não pode ser maior que a data atual");

		EstadoDaCena novoEstadoDaCena = cenaVO.getEstadoDaCena();

		Cena cenaAtual = buscarCenaPorId(cenaVO.getId());

		boolean permitido = cenaAtual.getEstadoDaCena().permiteAlterarEstadoDaCenaPara(novoEstadoDaCena.getValor());

		if (!permitido)
			throw new Exception("Alteração de estado não permitida");

		cenaAtual.setEstadoDaCena(novoEstadoDaCena);

		repositorio.save(cenaAtual);
	}

	public List<Cena> listarCenas() {
		return repositorio.findAll();
	}

}
