package tela;

import controladores.ControladorUrna;
import enums.*;
import java.util.*;
import modelo.*;
import controladores.*;

public class TelaVotacao extends Tela {

	int votosEmBrancoGovernador;
	int votosNuloGovernador;
	int votosEmBrancoDeputado;
	int votosNuloDeputado;

	public void exibe() {
		System.out.println("--- Votação ---");
		System.out.println("Votar        (1)");
		System.out.println("Listar Urnas (2)");
		System.out.println("Encerrar     (3)");

		int opcao = getInt();
		// Para executar ações dado a opção desejada
		switch (opcao) {
		case 1:
			votar();
			break;
		case 2:
			mostrarVotacaoUrna();
			break;	
		case 3:
			mostrarResultados();

			return;
		default:
			System.out.println("Comando não reconhecido");
			break;
		}
		exibe();
	}
	// Inicia votação
	private void votar() {
		System.out.println("Digite a cidade em que você deseja: ");
		String nomeCidade = sc.nextLine();
		// Cria uma nova cidade que "puxa" o getCidadebyNome do controlador
		Cidade cidade = ControladorCidade.getInstance().getCidadeByName(nomeCidade);

		System.out.println("Digite a zona: ");
		int zona = getInt();

		System.out.println("Digite a seção: ");
		int secao = getInt();
		// Cria uma nova urna chamada urna que "puxa" o getUrna da classe controladorUrna
		Urna urna = ControladorUrna.getInstance().getUrna(cidade, zona, secao);

		if (urna == null) {
			
			System.out.println("Erro: urna não encontrada");
			return;
		}
		// Votação governador
		System.out.println("Urna encontrada! Digite o número do seu candidato para governador:");
		int numeroGovernador = getInt();
		Candidato governador = ControladorCandidato.getInstance().getCandidato(numeroGovernador, Cargo.GOVERNADOR);
		urna.votarEmGovernador(numeroGovernador, governador);

		// Votação deputado
		System.out.println("Digite o número do seu candidato para deputado:");
		int numeroDeputado = getInt();
		Candidato deputado = ControladorCandidato.getInstance().getCandidato(numeroDeputado, Cargo.DEPUTADO);
		urna.votarEmDeputado(numeroDeputado, deputado);

		System.out.println("Votação concluida com sucesso!");
	}

	private void mostrarResultados() {

		int votosEmBrancoDeputado = 0;
		int votosNuloDeputado = 0;
		// Apura votos, salvado-os nas entidades Candidatos e Partidos. Soma os votos
		// nulos e brancos para deputado.
		for (Urna urna : ControladorUrna.getInstance().urnas) {
			urna.apuraResultados();
			votosEmBrancoDeputado += urna.votosEmBrancoDeputado;
			votosNuloDeputado += urna.votosNuloDeputado;
		}
		int votosValidos = votosEmBrancoDeputado + votosNuloDeputado;

		// Mostra listagem de candidatos e seus respectivos votos
		// for (Candidato candidato : ControladorCandidato.getInstance().candidatos)
		// System.out.println("Candidato " + candidato.nome + " recebeu " +
		// candidato.votos + " votos." );

		// Soma os votos dos deputados
		for (Candidato deputado : ControladorCandidato.getInstance().getCandidatos(Cargo.DEPUTADO))
			votosValidos += deputado.votos;

		// calcula o valor do quociente
		int quocienteEleitoral = (int) Math.round(votosValidos / 3.0);
		System.out.println("Quociente eleitoral Deputados: " + quocienteEleitoral);

		// Retorna governador eleito
		Candidato governadorEleito = ControladorCandidato.getInstance().getGovernadorEleito();
		
		// Retorna os 3 deputados eleitos
		List<Candidato> deputadosEleitos = ControladorCandidato.getInstance().getDeputadosEleitos(quocienteEleitoral);

		System.out.println(
				governadorEleito.nome + " foi eleito como governador com " + governadorEleito.votos + " votos!");

		for (Candidato deputadoEleito : deputadosEleitos) {
			System.out
					.println(deputadoEleito.nome + " foi eleito como deputado com " + deputadoEleito.votos + " votos!");

		}

	}
	// Mostra quantidade de votos por Urnas
	public void mostrarVotacaoUrna() {
		ControladorUrna.getInstance().exibeResultado();
	}

}
