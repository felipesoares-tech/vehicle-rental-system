package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.*;
import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class Veiculo {
    @Column(length = 10)
    protected String marca;
    @Column(length = 10)
    protected String modelo;
    @Column(length = 5)
    protected Integer anoFabricacao;
    @Column(length = 5)
    protected Integer anoModelo;
    @Column(length = 20)
    protected Double preco;
    @Id
    @Column(length = 7, nullable = false)
    protected String placa;
}