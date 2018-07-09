package controladores;

import exceptions.NumeroInvalidoException;
import enums.*;
import exceptions.*;
import java.util.*;
import java.util.stream.Collectors;

import modelo.*;

public class ControladorCandidato extends Controlador {
	public final ArrayList<Candidato> candidatos = new ArrayList<>();


	private static ControladorCandidato instance;

	public static ControladorCandidato getInstance() {
		if (instance == null)
			instance = new ControladorCandidato();
		return instance;
	}

	public Candidato cadastra(String nome, Cargo cargo, int numero, String siglaPartido) throws CampoVazioException, EntidadeNotFoundException, CadastroRepetidoException, NumeroInvalidoException {
		// verificações
		if (numero < 1 || numero > 98)
			throw new NumeroInvalidoException();

		verificaCampoVazio(nome, "Nome candidato");
		verificaCampoVazio(siglaPartido, "Sigla do partido");

		// Pega as info
		Partido partido = ControladorPartido.getInstance().getPartidoBySigla(siglaPartido);

		// verifica
		if (partido == null)
			throw new EntidadeNotFoundException(
					"Erro: não foi possivel encontrar partido com sigla '" + siglaPartido + "'.");
		if (getCandidatoByNumero(numero) != null)
			throw new CadastroRepetidoException("Erro: candidato com numero '" + numero + "' ja cadastrado.");

		Candidato candidato = new Candidato(nome, cargo, numero, partido);
		candidatos.add(candidato);
		return candidato;
	}

	public void remove(Candidato candidato) {
		candidatos.remove(candidato);
	}

	public Candidato getCandidatoByNumero(int numero) {
		return candidatos.stream()
				.filter(candidato -> candidato.numero == numero)
				.findFirst().orElse(null);
	}

// Compara com os dados passados através de parametros e retorna o primeiro	
	public Candidato getCandidato(int numero, Cargo cargo) {
		return candidatos.stream()
				.filter(candidato -> candidato.numero == numero)
				.filter(candidato -> candidato.cargo == cargo)
				.findFirst().orElse(null);
	}

//Procura candidado de acordo com o cargo passado, compara, e atribui colocando no array
	public List<Candidato> getCandidatos(Cargo cargo) {
		return candidatos.stream()
				.filter(candidato -> candidato.cargo == cargo)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Candidato getGovernadorEleito() {	
		Candidato eleito = null;
		for (Candidato candidato : getCandidatos(Cargo.GOVERNADOR)) {
			if (eleito == null || candidato.votos > eleito.votos) {
				eleito = candidato;
			}
		}
		return eleito;
	}
	// Pega os Deputados eleitos, compara com o quociente e instancia um novo array
	public List<Candidato> getDeputadosEleitos(int quocienteEleitoral) {
	    return getCandidatos(Cargo.DEPUTADO).stream()
	        .filter(candidato -> candidato.votos >= quocienteEleitoral)
	        .collect(Collectors.toCollection(ArrayList::new));    
	}
	
}
