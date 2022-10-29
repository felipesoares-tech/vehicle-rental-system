package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@ToString(callSuper=true)
@DiscriminatorValue("onibus")
@JsonTypeName("onibus")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Onibus extends Veiculo{
    private Integer quantidadePassageiros;
    private Integer quantidadeEixos;
}
