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
    public List<Carro> findAll() {
        return manager.createQuery("from Carro", Carro.class).getResultList();
    }

    @Override
    public Carro findById(String id) {
        return manager.find(Carro.class, id);
    }

    @Override
    @Transactional
    public Carro save(Carro carro) {
        System.out.println("Carro: "+carro.getPlaca());
        return manager.merge(carro);
    }

    @Override
    @Transactional
    public void deleteById(Carro carro) {
        System.out.println("Carro: "+carro.getPlaca());
        carro = findById(carro.getPlaca());
        manager.remove(carro);
    }
}
