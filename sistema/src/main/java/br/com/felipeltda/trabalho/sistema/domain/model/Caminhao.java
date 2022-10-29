package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
//@DiscriminatorValue("caminhao")
public class Caminhao extends Veiculo{
    private Double capacidadeCarga;
}
