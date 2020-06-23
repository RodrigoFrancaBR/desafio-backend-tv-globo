package br.com.franca.servico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.EstadoDaCena;
import br.com.franca.dominio.enums.Estado;
import br.com.franca.dominio.vo.v1.CenaVO;
import br.com.franca.repositorio.CenaRepositorio;
import br.com.franca.repositorio.EstadoDaCenaRepositorio;

@Service
public class CenaServico {

	private CenaRepositorio cenaRepositorio;
	private EstadoDaCenaRepositorio estadoDaCenaRepositorio;

	public CenaServico(CenaRepositorio cenaRepositorio, EstadoDaCenaRepositorio estadoDaCenaRepositorio) {
		this.cenaRepositorio = cenaRepositorio;
		this.estadoDaCenaRepositorio = estadoDaCenaRepositorio;
	}

	public Cena gravarCena(Cena cena) {
		return cenaRepositorio.save(cena);
	}

	public EstadoDaCena gravarEstadoDaCena(EstadoDaCena estadoDaCena) {
		return estadoDaCenaRepositorio.save(estadoDaCena);
	}

	public CenaVO buscarCenaPorId(Long id) {
		Cena cenaEncontrada = cenaRepositorio.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Não foi encontrada nenhuma cena para o ID informado "));
		return converterParaCenaVO(cenaEncontrada);
	}

	public List<CenaVO> listarCenas() {
		List<Cena> listaDeCenas = cenaRepositorio.findAll();
		return converteParaListaDeCenaVO(listaDeCenas);
	}

	public void alterarEstadoDaCena(CenaVO cenaVO) {

		if (cenaVO == null)
			throw new IllegalArgumentException("A nova cena não pode ser null");

		if (cenaVO.getEstado() == null)
			throw new IllegalArgumentException("O estado da nova cena não pode ser null");

		if (cenaVO.getDataDeAlteracao() == null)
			throw new IllegalArgumentException("A dataDeAlteracao não pode ser null");
				

		if (cenaVO.getDataDeAlteracao().isAfter(LocalDateTime.now()))
			throw new IllegalArgumentException("A dataDeAlteracao não pode ser maior que a data atual");

		CenaVO cenaAtualVO = buscarCenaPorId(cenaVO.getId());

		if (!permiteAlterarEstadoDaCena(cenaAtualVO.getEstado(), cenaVO.getEstado()))
			throw new IllegalArgumentException("Alteração de estado não permitida");

		cenaAtualVO.setEstado(cenaVO.getEstado());

		cenaAtualVO.setDataDeAlteracao(cenaVO.getDataDeAlteracao());

		estadoDaCenaRepositorio.save(converterParaEstadoDaCena(cenaAtualVO));

		cenaRepositorio.save(converterParaCena(cenaAtualVO));

	}

	private EstadoDaCena converterParaEstadoDaCena(CenaVO cenaVO) {
		return new EstadoDaCena(cenaVO.getEstado(), cenaVO.getDataDeAlteracao(), new Cena(cenaVO.getId()));
	}

	private Cena converterParaCena(CenaVO cenaAtual) {
		return new Cena(cenaAtual.getId(), cenaAtual.getNome(), cenaAtual.getEstado());
	}

	private List<CenaVO> converteParaListaDeCenaVO(List<Cena> listaDeCenas) {
		return listaDeCenas.parallelStream().map(e -> new CenaVO(e.getId(), e.getNomeDaCena(), e.getEstado()))
				.collect(Collectors.toList());
	}

	private CenaVO converterParaCenaVO(Cena cena) {
		return new CenaVO(cena.getId(), cena.getNomeDaCena(), cena.getEstado());
	}

	private boolean permiteAlterarEstadoDaCena(Estado estadoAtual, Estado novoEstado) {
		return estadoAtual.permiteAlterarEstadoDaCenaPara(novoEstado.getValor());
	}

}
