package br.com.felipeltda.trabalho.sistema.domain.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String telefone;
    @Column(length = 11, nullable = false)
    private String cpf;
}
