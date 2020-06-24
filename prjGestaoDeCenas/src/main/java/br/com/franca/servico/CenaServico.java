package br.com.franca.servico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
		Cena cenaEncontrada = findById(id);
		return converterParaCenaVO(cenaEncontrada);
	}

	public List<CenaVO> listarCenas() {
		List<Cena> listaDeCenas = cenaRepositorio.findAll();
		return converteParaListaDeCenaVO(listaDeCenas);
	}

	public CenaVO alterarEstadoDaCena(CenaVO cenaVO) {

		if (cenaVO == null)
			throw new IllegalArgumentException("Uma cena precisa ser informada");

		if (cenaVO.getNomeDoEstado() == null)
			throw new IllegalArgumentException("Um estado precisa ser informado");

		if (cenaVO.getDataInformada() == null)
			throw new IllegalArgumentException("Uma data de alteração de estado precisa ser informado");

		if (cenaVO.getDataInformada().isAfter(LocalDateTime.now()))
			throw new IllegalArgumentException(
					"A data de Alteracao de estado precisa ser menor que a data/hora atual ");

		Cena cenaAtual = findById(cenaVO.getId());

		if (!permiteAlterarEstadoDaCenaPara(cenaAtual.getNomeDoEstado(), cenaVO.getNomeDoEstado()))
			throw new IllegalArgumentException("Alteração de estado não permitida");
		
		cenaAtual.setDataInformada(cenaVO.getDataInformada());
		
		cenaAtual.setNomeDoEstado(cenaVO.getNomeDoEstado());
		
		estadoDaCenaRepositorio.save(converterParaEstadoDaCena(cenaAtual));

		Cena cenaSalva = cenaRepositorio.save(cenaAtual);
		return converterParaCenaVO(cenaSalva);

	}

	public CenaVO desfazerAlteracaoDeEstado(CenaVO cenaVO) throws Exception {

		if (cenaVO == null)
			throw new IllegalArgumentException("Uma cena precisa ser informada");

		if (cenaVO.getNomeDoEstado() == null)
			throw new IllegalArgumentException("Um estado precisa ser informado");

		Cena cenaAtual = findById(cenaVO.getId());
		
		List<EstadoDaCena> listaDeEstados = estadoDaCenaRepositorio.findByCena(cenaAtual);
		
		Optional<EstadoDaCena> estadoMaisRecente = listaDeEstados.parallelStream().reduce((e1, e2)->e1.getDataDaOperacao().isAfter(e2.getDataDaOperacao())?e1:e2);

		if (!permiteDesfazerAlteracaoDeEstado(cenaAtual, cenaVO))
			throw new IllegalArgumentException("Desfazer alteração de estado não permitida");

		if (ultimaAlteracaoDeEstadoMaiorQueCincoMinutos(estadoMaisRecente.get().getDataDaOperacao()))
			throw new Exception("Desfazer alteração de estado não permitida");

		cenaAtual.setNomeDoEstado(cenaVO.getNomeDoEstado());		

		estadoDaCenaRepositorio.save(converterParaEstadoDaCena(cenaAtual));

		Cena cenaAtualizada = cenaRepositorio.save(cenaAtual);
		return converterParaCenaVO(cenaAtualizada);
		

	}

	private Cena findById(Long id) {
		return cenaRepositorio.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Não foi encontrada nenhuma cena para o ID informado "));
	}

	private boolean permiteAlterarEstadoDaCenaPara(Estado estadoAtual, Estado novoEstado) {
		return estadoAtual.permiteAlterarEstadoDaCenaPara(novoEstado.getValor());
	}

	private boolean permiteDesfazerAlteracaoDeEstado(Cena cenaAtual, CenaVO cenaVO) {
		return cenaAtual.getNomeDoEstado().permiteDesfazerAlteracaoDeEstado(cenaVO.getNomeDoEstado().getValor());
	}

	private boolean ultimaAlteracaoDeEstadoMaiorQueCincoMinutos(LocalDateTime dataDaUltimaOperacao) {
		LocalDateTime dataLimite = dataDaUltimaOperacao.plusMinutes(5);
		return LocalDateTime.now().isAfter(dataLimite) ? true : false;
	}

	private EstadoDaCena converterParaEstadoDaCena(Cena cena) {
		return new EstadoDaCena(cena.getNomeDoEstado(), cena.getDataInformada(), LocalDateTime.now(), cena);
	}

	private List<CenaVO> converteParaListaDeCenaVO(List<Cena> listaDeCenas) {
		return listaDeCenas.parallelStream().map(
				cena -> new CenaVO(cena.getId(), cena.getNomeDaCena(), cena.getNomeDoEstado(), cena.getDataInformada()))
				.collect(Collectors.toList());
	}

	private CenaVO converterParaCenaVO(Cena cena) {
		return new CenaVO(cena.getId(), cena.getNomeDaCena(), cena.getNomeDoEstado(), cena.getDataInformada());
	}

}
