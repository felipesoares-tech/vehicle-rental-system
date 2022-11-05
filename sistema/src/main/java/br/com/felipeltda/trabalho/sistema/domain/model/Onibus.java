package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import javax.persistence.*;

@Entity
@ToString(callSuper=true)
@DiscriminatorValue("onibus")
@JsonTypeName("onibus")
@Getter
public class Onibus extends Veiculo{
    private Integer quantidadePassageiros;
    private Integer quantidadeEixos;
}
