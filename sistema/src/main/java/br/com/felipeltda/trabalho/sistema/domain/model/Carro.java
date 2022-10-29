package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("carro")
@JsonTypeName("carro")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper=true)
public class Carro extends Veiculo{
    private Integer quantidadePortas;

}