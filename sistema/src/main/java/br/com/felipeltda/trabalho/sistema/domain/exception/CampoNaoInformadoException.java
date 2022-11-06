package br.com.felipeltda.trabalho.sistema.domain.exception;

import org.hibernate.PropertyValueException;

public class CampoNaoInformadoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public CampoNaoInformadoException(String mensagem){
        super(mensagem);
    }
}
