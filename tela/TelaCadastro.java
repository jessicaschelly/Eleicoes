package tela;

import interfaces.ITela;
import java.util.Scanner;

public abstract class TelaCadastro extends Tela {
    @Override
    public void exibe() {
        System.out.println("Cadastrar   (1)");
        System.out.println("Listar      (2)");
        System.out.println("Sair        (3)");

        int opcao = getInt();
        
        switch (opcao) {
            case 1:
                exibeCadastro();
                break;
            case 2:
            	exibeLista();
                break;          
            case 3:
                return;
            default:
                System.out.println("Comando nao reconhecido, tente novamente.");
                break;
        }
        exibe();

    }
    
  
    // Por ser uma classe abstrata ela tem esses elementos que devem ser implementados
    // nas demais classes que extenderem
	public abstract void exibeCadastro();
    public abstract void exibeLista();

}
