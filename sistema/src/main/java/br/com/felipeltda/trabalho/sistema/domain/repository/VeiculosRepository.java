package br.com.felipeltda.trabalho.sistema.domain.repository;

import br.com.felipeltda.trabalho.sistema.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculo,String> {
}
