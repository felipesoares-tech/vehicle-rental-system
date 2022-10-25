package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import java.util.List;

public interface CaminhaoRepository {
    List<Caminhao> listar();
    Caminhao buscar(String id);
    Caminhao salvar(Caminhao Caminhao);
    Caminhao cadastrar();
    void remover(Caminhao Caminhao);
}
