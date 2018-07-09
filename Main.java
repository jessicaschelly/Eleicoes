import modelo.*;
import controladores.*;
import enums.*;
import exceptions.*;
import java.util.*;
import java.util.logging.*;
import tela.TelaPrincipal;

public class Main {
    public static void main(String[] args){
        
        try {
            ControladorCidade.getInstance().cadastra("Sao Jose");
            ControladorCidade.getInstance().cadastra("Florian�polis");
            
            ControladorEleitor.getInstance().cadastra("Nhe", "1");

            ControladorPartido.getInstance().cadastra("Partido dos trabalhadores", "PT");
            ControladorPartido.getInstance().cadastra("Psdasda", "PSDB");
            
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.GOVERNADOR, 1, "PT").votos = 10;
            ControladorCandidato.getInstance().cadastra("Maria", Cargo.GOVERNADOR, 3, "PSDB").votos = 12;

            ControladorCandidato.getInstance().cadastra("A", Cargo.DEPUTADO, 5, "PSDB").votos = 11;
            ControladorCandidato.getInstance().cadastra("B", Cargo.DEPUTADO, 6, "PSDB").votos = 12;
            ControladorCandidato.getInstance().cadastra("C", Cargo.DEPUTADO, 7, "PSDB").votos = 20;
            
            ControladorUrna.getInstance().cadastra(1, 1, Turno.SEGUNDO, "Sao Jose");
            ControladorUrna.getInstance().cadastra(1, 2, Turno.SEGUNDO, "Sao Jose");
            
            //                        secao, zona (ao contrario do que pede na vota��o
            ControladorUrna.getInstance().cadastra(1, 1, Turno.SEGUNDO, "Florian�polis");
            ControladorUrna.getInstance().cadastra(1, 2, Turno.SEGUNDO, "Florian�polis");
        } catch (NumeroInvalidoException | CampoVazioException | CadastroRepetidoException | EntidadeNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        new TelaPrincipal().exibe();
        
        
        if (true)
            return;
        
    }
}
    