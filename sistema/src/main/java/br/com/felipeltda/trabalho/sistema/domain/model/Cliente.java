package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cliente {
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String telefone;
    @Id
    @Column(length = 11, nullable = false)
    @EqualsAndHashCode.Include
    private String cpf;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return cpf != null && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
