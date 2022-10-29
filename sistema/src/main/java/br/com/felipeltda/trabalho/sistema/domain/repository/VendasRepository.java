package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import java.util.List;

public interface VendasRepository {
    List<Venda> findAll();
    Venda findById(Integer id);
    Venda save(Venda venda);
    void deleteById(Venda venda);
}
