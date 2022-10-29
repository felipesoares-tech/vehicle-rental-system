package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("caminhao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonTypeName("caminhao")
@ToString(callSuper=true)
public class Caminhao extends Veiculo{
    private Double capacidadeCarga;
}
