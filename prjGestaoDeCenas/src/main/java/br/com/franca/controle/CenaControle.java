package br.com.franca.controle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.dominio.vo.v1.CenaVO;
import br.com.franca.servico.CenaServico;

@RestController
@RequestMapping("/api/v1/cenas")
public class CenaControle {

	private CenaServico servico;

	public CenaControle(CenaServico cenaServico) {
		this.servico = cenaServico;
	}

	@PutMapping
	public void alterarEstadoDaCena(@RequestBody CenaVO cenaVO) throws Exception {
		servico.alterarEstadoDaCena(cenaVO);
	}
	
	// Listar cenas com seus estados atuais;
	@GetMapping
	public List<CenaVO> listarCenas() {
		return servico.listarCenas();
	}

	// Obter dado de uma cena específica.
	@GetMapping("/{id}")
	public CenaVO buscarCenaPorId(@PathVariable("id") Long id) throws Exception {
		return servico.buscarCenaPorId(id);
	}

}
