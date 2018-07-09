package controladores;

import exceptions.CampoVazioException;

abstract class Controlador {
    public void verificaCampoVazio(String campo, String nomeCampo) throws CampoVazioException{
        if (campo == null || campo.isEmpty())
            throw new exceptions.CampoVazioException("Erro: nao � permitido campo vazio (" + nomeCampo + ")");
    }   
}
