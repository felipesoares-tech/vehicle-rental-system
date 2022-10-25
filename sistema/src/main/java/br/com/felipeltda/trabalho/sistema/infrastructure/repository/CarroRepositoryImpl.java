package br.com.felipeltda.trabalho.sistema.infrastructure.repository;

import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarroRepositoryImpl implements CarrosRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Carro> listar() {
        return manager.createQuery("from Carro", Carro.class).getResultList();
    }

    @Override
    public Carro cadastrar() {
        return manager.createQuery("from Carro",Carro.class).getSingleResult();
    }

    @Override
    public Carro buscar(String id) {
        return manager.find(Carro.class, id);
    }

    @Override
    @Transactional
    public Carro salvar(Carro carro) {
        System.out.println("carro: "+carro.getPlaca());
        return manager.merge(carro);
    }
    @Override
    @Transactional
    public void remover(Carro carro) {
        System.out.println("carro: "+carro.getPlaca());
        carro = buscar(carro.getPlaca());
        manager.remove(carro);
    }
}
