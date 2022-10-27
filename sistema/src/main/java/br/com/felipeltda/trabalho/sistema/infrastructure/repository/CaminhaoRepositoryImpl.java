package br.com.felipeltda.trabalho.sistema.infrastructure.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CaminhaoRepositoryImpl implements CaminhaoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Caminhao> findAll() {
        return manager.createQuery("from Caminhao", Caminhao.class).getResultList();
    }

    @Override
    public Caminhao findById(String id) {
        return manager.find(Caminhao.class, id);
    }

    @Override
    @Transactional
    public Caminhao save(Caminhao caminhao) {
        System.out.println("Caminhao: "+caminhao.getPlaca());
        return manager.merge(caminhao);
    }

    @Override
    @Transactional
    public void deleteById(Caminhao caminhao) {
        System.out.println("Caminhao: "+caminhao.getPlaca());
        caminhao = findById(caminhao.getPlaca());
        manager.remove(caminhao);
    }

}
