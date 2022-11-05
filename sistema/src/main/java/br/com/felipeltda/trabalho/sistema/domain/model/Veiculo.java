package br.com.felipeltda.trabalho.sistema.domain.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "veiculo")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Veiculo veiculo = (Veiculo) o;
        return placa != null && Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}