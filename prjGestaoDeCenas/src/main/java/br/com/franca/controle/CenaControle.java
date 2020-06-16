package br.com.franca.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.vo.v1.CenaVO;
import br.com.franca.servico.CenaServico;

@RestController
@RequestMapping("/api/cenas/v1")
public class CenaControle {
	private CenaServico servico;

	public CenaControle(CenaServico servico) {
		this.servico = servico;
	}

	@GetMapping("/{id}")
	public Cena buscarCenaPorId(@PathVariable("id") Long id) {
		return servico.buscarCenaPorId(id).get();
	}

	@PutMapping
	public void alterarEstadoDaCena(@RequestBody CenaVO cenaVO) {
		servico.alterarEstadoDaCena(cenaVO);
	}

}
