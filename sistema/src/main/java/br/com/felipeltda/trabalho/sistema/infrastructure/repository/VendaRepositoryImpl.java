package br.com.felipeltda.trabalho.sistema.infrastructure.repository;

import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VendaRepositoryImpl implements VendasRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public Venda save(Venda venda) {
        System.out.println("Venda: "+venda.getId());
        return manager.merge(venda);
    }

    @Override
    public List<Venda> findAll() {
        return manager.createQuery("from Venda", Venda.class).getResultList();
    }

    @Override
    public Venda findById(Integer id) {
        return manager.find(Venda.class, id);
    }

    @Override
    @Transactional
    public void deleteById(Venda venda) {
        System.out.println("Venda: "+venda.getId());
        venda = findById(venda.getId());
        manager.remove(venda);
    }
}
