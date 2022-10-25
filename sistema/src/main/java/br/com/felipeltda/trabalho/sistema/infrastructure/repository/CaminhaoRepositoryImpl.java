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
    public List<Caminhao> listar() {
        return manager.createQuery("from Caminhao", Caminhao.class).getResultList();
    }

    @Override
    public Caminhao cadastrar() {
        return manager.createQuery("from Caminhao",Caminhao.class).getSingleResult();
    }

    @Override
    public Caminhao buscar(String id) {
        return manager.find(Caminhao.class, id);
    }

    @Override
    @Transactional
    public Caminhao salvar(Caminhao caminhao) {
        System.out.println("Caminhao: "+caminhao.getPlaca());
        return manager.merge(caminhao);
    }
    @Override
    @Transactional
    public void remover(Caminhao caminhao) {
        System.out.println("Caminhao: "+caminhao.getPlaca());
        caminhao = buscar(caminhao.getPlaca());
        manager.remove(caminhao);
    }
}
