package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("carro")
@JsonTypeName("carro")
@ToString(callSuper=true)
@Getter
public class Carro extends Veiculo{
    private Integer quantidadePortas;

}