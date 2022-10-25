package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import java.util.List;

public interface CarrosRepository {
    List<Carro> listar();
    Carro buscar(String id);
    Carro salvar(Carro carro);
    Carro cadastrar();
    void remover(Carro carro);

}
