package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
//@DiscriminatorValue("carro")
public class Carro extends Veiculo{
    private Integer quantidadePortas;

}