package br.com.felipeltda.trabalho.sistema.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entidade não encontrada")
public class EntidadeNaoEncontrada  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeNaoEncontrada(String mensagem){
        super(mensagem);
    }
}
