Projeto construido usando Spring Boot

Para rodar o projeto siga os passos abaixo:

1 - Fazer o clone do repositório através do comando 
	git clone git@github.com:RodrigoFrancaBR/desafio-backend-tv-globo.git

2 - Importar o projeto maven na ide
3 - Executar a classe InicioDoProjeto.java (Run As Java Application)
4 - Acessar o banco em memória (h2) através do endereço
	http://localhost:8080/db/h2/
	JDBC URL: jdbc:h2:mem:cenadb
	User Name: root
	Password:
	Tabelas disponíveis: 
	TB_CENA com as cenas cadastradas. 
	TB_ESTADO_CENA com os estados da cenas.

5 - Utilizando o Postman para fazer as requisições http
	importe o arquivo desafio-backend-tv-globo.postman_collection para obter as requisições http.

	listarCenas (http://localhost:8080/api/v1/cenas)
	lista todas as cenas cadastradas e seus estados atuais.

	buscarCenaPorId (http://localhost:8080/api/v1/cenas/1)
	lista uma cena específica com seu estado atual.

	obterEstadosDeUmaCena (http://localhost:8080/api/v1/cenas/1/estados)
	lista todos os estados de uma cena em específico.

	alterarEstadoDaCena(http://localhost:8080/api/v1/cenas)
	Altera o estado de uma cena em específico
	
	ex: Alterando o estado para PREPARADA.
		{
    		"id": 1,
    		"nomeDoEstado": "PREPARADA",
    		"dataInformada": "2020-06-24T19:03:00Z"
		}

	desfazerAlteracaoDoEstado (http://localhost:8080/api/v1/cenas)
	Desfaz uma alteração de estado.
	
	ex: Desfazendo uma alteração de estado para PENDENTE
		{
    		"id": 1,
    		"nomeDoEstado": "PENDENTE"    
		}