package br.com.franca;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.franca.dominio.Cena;
import br.com.franca.dominio.enums.EstadoDaCena;
import br.com.franca.servico.CenaServico;

@SpringBootApplication
public class InicioDoProjeto {

	public static void main(String[] args) {	
		SpringApplication.run(InicioDoProjeto.class, args);		
	}

	@Bean
	CommandLineRunner init(CenaServico servico) {
		return args -> {
			servico.apagarTodasAsCenas();
			LongStream.range(1, 11).mapToObj(i -> {
				Cena novaCena = new Cena();
				novaCena.setNomeDaCena("Cena " + i);
				novaCena.setEstadoDaCena(EstadoDaCena.PENDENTE);
				return novaCena;
			}).map(c -> servico.gravarCena(c)).forEach(System.out::println);
		};
	}
}
