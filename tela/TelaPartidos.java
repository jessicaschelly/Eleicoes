package tela;

import modelo.Partido;
import exceptions.*;

import java.util.ArrayList;

import controladores.*;

public class TelaPartidos extends TelaCadastro {
	@Override
	public void exibe() {
		System.out.println("--- Tela Partidos ---");
		super.exibe();
	}

	@Override
	public void exibeCadastro() {
		System.out.println("Insira o nome do partido: ");
		String nome = sc.nextLine();
		System.out.println("Insira a sigla do partido: ");
		String sigla = sc.nextLine();

		try {
			ControladorPartido.getInstance().cadastra(nome, sigla);
			System.out.println("Partido cadastrado com sucesso!");
		} catch (CampoVazioException | CadastroRepetidoException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void exibeLista() {
		ArrayList<Partido> partidos = ControladorPartido.getInstance().partidos;
		if (partidos.size() == 0) {
			System.out.println("Não há partidos cadastrados.");
			return;
		}

		System.out.println("Partidos:");
		for (Partido partido : partidos) {
			System.out.println("Partidos disponíveis para votação: " + partido.nome);
		}
	}

}
