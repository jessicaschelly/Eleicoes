package tela;
import modelo.Urna;
import java.util.ArrayList;
import controladores.*;
import enums.*;
import exceptions.*;

public class TelaUrnas extends TelaCadastro {
	@Override
	public void exibe() {
		System.out.println("--- Tela Urnas ---");
		super.exibe();
	}

	@Override
	public void exibeCadastro() {
		System.out.println("Insira a se��o da urna:");
		int secao = getInt();

		System.out.println("Insira a zona da urna:");
		int zona = getInt();

		System.out.println("Insira a cidade:");
		String cidade = sc.nextLine();

		System.out.println("Primeiro (1) ou segundo (2) turno?");
		Turno turno = Turno.getTurno(getInt());
		
		if (turno == null) {
			System.out.println("Erro: numero do turno tem que ser 1 ou 2");
			return;
		}

		try {
			ControladorUrna.getInstance().cadastra(secao, zona, turno, cidade);
			System.out.println("Cidade cadastrada com sucesso");
		} catch (CampoVazioException | EntidadeNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void exibeLista() {
		ArrayList<Urna> urnas = ControladorUrna.getInstance().urnas;
		if (urnas.size() == 0) {
			System.out.println("N�o h� urnas cadastrados.");
			return;
		}

		System.out.println("Urnas:");
		for (Urna urna : urnas) {
			System.out.println("Urnas dispon�veis para vota��o: ");
			System.out.println("Se��o: " + urna.secao);
			System.out.println("Zona: " + urna.zona);
			System.out.println("Zona: " + urna.cidade.nome);
			
		}
	}
}
