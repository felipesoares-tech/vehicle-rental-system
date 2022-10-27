package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import java.util.List;

public interface OnibusRepository {

    List<Onibus> findAll();
    Onibus findById(String id);
    Onibus save(Onibus onibus);
    void deleteById(Onibus onibus);

}
