package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import java.util.List;

public interface CarrosRepository {
    List<Carro> findAll();
    Carro findById(String id);
    Carro save(Carro carro);
    void deleteById(Carro carro);

}
