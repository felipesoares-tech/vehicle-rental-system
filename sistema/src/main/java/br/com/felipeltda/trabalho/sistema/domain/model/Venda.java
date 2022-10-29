package br.com.felipeltda.trabalho.sistema.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    @Column(length = 20)
    private Double preco;
}
