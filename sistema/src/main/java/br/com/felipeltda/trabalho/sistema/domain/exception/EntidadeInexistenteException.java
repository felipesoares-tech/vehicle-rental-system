package br.com.felipeltda.trabalho.sistema.domain.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ENTIDADE NAO ENCONTRADA")
public class EntidadeInexistenteException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeInexistenteException(String mensagem){
        super(mensagem);
    }
}
