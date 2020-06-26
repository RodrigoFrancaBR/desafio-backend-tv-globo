package br.com.franca;

import java.time.LocalDateTime;
import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.enums.Estado;
import br.com.franca.servico.CenaServico;
import br.com.franca.servico.EstadoDaCenaServico;

@SpringBootApplication
public class InicioDoProjeto {

	public static void main(String[] args) {
		SpringApplication.run(InicioDoProjeto.class, args);
	}

	@Bean
	CommandLineRunner init(CenaServico cenaServico,
			EstadoDaCenaServico estadoDaCenaServico) {

		return args -> {

			LongStream.range(1, 11)

					.mapToObj(i -> {
						Cena cena = new Cena();
						cena.setId(i);
						cena.setNomeDaCena("Cena " + i);
						cena.setNomeDoEstado(Estado.PENDENTE);
						cena.setDataInformada(LocalDateTime.now());
						return cena;
					})

					.map(cena -> cenaServico.gravarCena(cena))

					/*.map(cena -> {
						EstadoDaCena estadoDaCena = new EstadoDaCena();
						estadoDaCena.setNomeDoEstado(Estado.PENDENTE);
						estadoDaCena.setDataInformada(cena.getDataInformada());
						estadoDaCena.setDataDaOperacao(LocalDateTime.now());
						estadoDaCena.setNomeDaOperacao(null);
						estadoDaCena.setCena(cena);
										
						
						
						return estadoDaCena;
					})*/

					// .map(estadoDaCena -> estadoDaCenaServico.gravarEstadoDaCena(estadoDaCena))

					.forEach(System.out::println);
		};
	}
}
