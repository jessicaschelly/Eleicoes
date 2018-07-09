package tela;
import modelo.Candidato;

import enums.*;
import exceptions.*;
import modelo.Cidade;

import java.util.ArrayList;

import controladores.*;

public class TelaCandidatos extends TelaCadastro {

    @Override
    public void exibe(){
        System.out.println("--- Tela Candidatos ---");
        super.exibe();
    }
    // Inicia tela de cadastro
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome do candidato: ");
        String nome = sc.nextLine();
        
        System.out.println("Insira o numero do candidato: ");
        int numero = getInt();           
        
        System.out.println("Insira a sigla do partido: ");
        String siglaPartido = sc.nextLine();
        
        System.out.println("Governador (G) ou Deputado (D)?");
        String letraCargo = sc.nextLine();
        
        Cargo cargo = Cargo.getCargo(letraCargo);
        if (cargo == null) {
            System.out.println("Erro: letra inserida diferente de G ou D");
            return;
        }
        
        try {
            ControladorCandidato.getInstance().cadastra(nome, cargo, numero, siglaPartido);
            System.out.println("Candidato cadastrado com sucesso!");
        } catch (CampoVazioException | EntidadeNotFoundException | CadastroRepetidoException | NumeroInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }

	@Override
   
    public void exibeLista() {
    	ArrayList<Candidato> candidatos = ControladorCandidato.getInstance().candidatos;
    	if (candidatos.size() == 0){
            System.out.println("N�o h� candidatos eleitores cadastrados.");
            return;
    	}
    	
    	  System.out.println("Candidatos concorrendo:");
          for (Candidato candidato : candidatos) {
              System.out.println("Nome: " + candidato.nome + ", Numero: " + candidato.numero + ", Cargo: " + candidato.cargo);
          }
      }
    }
	





