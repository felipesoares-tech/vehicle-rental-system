package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Carro extends Veiculo{
    private Integer quantidadePortas;

}