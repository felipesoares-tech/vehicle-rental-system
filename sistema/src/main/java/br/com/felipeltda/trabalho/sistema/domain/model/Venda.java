package br.com.felipeltda.trabalho.sistema.domain.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Veiculo> veiculos;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    @Column(length = 20)
    private Double preco;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
    private LocalDate data;
    private LocalTime hora;
}