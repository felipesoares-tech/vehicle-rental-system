package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String telefone;
    @Id
    @Column(length = 11, nullable = false)
    private String cpf;
}
