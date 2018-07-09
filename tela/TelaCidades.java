package tela;

import exceptions.*;
import modelo.Eleitor;
import modelo.Urna;
import modelo.Cidade;

import java.util.ArrayList;

import controladores.*;

public class TelaCidades extends TelaCadastro {

    @Override
    public void exibe(){
        System.out.println("--- Tela Cidades ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome da cidade: ");
        String nome = sc.nextLine();
        
        try {
            ControladorCidade.getInstance().cadastra(nome);
            System.out.println("Cidade cadastrada com sucesso!");
        } catch (CampoVazioException | CadastroRepetidoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void exibeLista() {
    	ArrayList<Cidade> cidades = ControladorCidade.getInstance().cidades;
    	if (cidades.size() == 0){
            System.out.println("Não há cidades eleitores cadastrados.");
            return;
    	}
    	
        System.out.println("Eleitores:");
        for (Cidade cidade : cidades) {
        	System.out.println("Cidades disponíveis: " + cidade.nome);
        }
       
    }
}
