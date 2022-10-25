package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Onibus extends Veiculo{
    private Integer quantidadePassageiros;
    private Integer quantidadeEixos;
}