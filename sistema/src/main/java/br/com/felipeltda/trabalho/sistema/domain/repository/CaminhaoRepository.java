package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import java.util.List;

public interface CaminhaoRepository {
    List<Caminhao> findAll();
    Caminhao findById(String id);
    Caminhao save(Caminhao caminhao);
    void deleteById(Caminhao caminhao);
}
