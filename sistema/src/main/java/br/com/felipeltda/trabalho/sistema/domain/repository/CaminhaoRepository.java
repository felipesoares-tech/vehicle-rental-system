package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao,String> {

}
