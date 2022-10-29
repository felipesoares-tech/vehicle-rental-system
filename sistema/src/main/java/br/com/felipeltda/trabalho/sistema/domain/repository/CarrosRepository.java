package br.com.felipeltda.trabalho.sistema.domain.repository;

import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carro,String> {

}
