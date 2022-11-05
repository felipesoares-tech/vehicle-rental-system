package br.com.felipeltda.trabalho.sistema.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "VEÍCULO NÃO INFORMADO")
public class VeiculoNaoInformadoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public VeiculoNaoInformadoException(String mensagem){
        super(mensagem);
    }
}
