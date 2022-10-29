package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "veiculo")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "tipo")
@JsonSubTypes({
        @Type(value = Carro.class, name = "carro"),
        @Type(value = Onibus.class, name = "onibus"),
        @Type(value = Caminhao.class, name = "caminhao")

})
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
    @Column(length = 8, nullable = false)
    protected String placa;
}