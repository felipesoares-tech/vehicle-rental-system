package br.com.felipeltda.trabalho.sistema.infrastructure.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OnibusRepositoryImpl implements OnibusRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public Onibus save(Onibus onibus) {
        System.out.println("Onibus: "+onibus.getPlaca());
        return manager.merge(onibus);
    }

    @Override
    public List<Onibus> findAll() {
        return manager.createQuery("from Onibus", Onibus.class).getResultList();
    }

    @Override
    public Onibus findById(String id) {
        return manager.find(Onibus.class, id);
    }

    @Override
    @Transactional
    public void deleteById(Onibus onibus) {
        System.out.println("Onibus: "+onibus.getPlaca());
        onibus = findById(onibus.getPlaca());
        manager.remove(onibus);
    }
}
