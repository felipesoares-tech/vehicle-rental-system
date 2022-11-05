package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("caminhao")
@JsonTypeName("caminhao")
@ToString(callSuper=true)
@Getter
public class Caminhao extends Veiculo{
    private Double capacidadeCarga;
}
