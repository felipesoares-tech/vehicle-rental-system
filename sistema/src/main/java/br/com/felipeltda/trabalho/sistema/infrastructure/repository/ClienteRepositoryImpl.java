package br.com.felipeltda.trabalho.sistema.infrastructure.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.repository.ClienteRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cliente> findAll() {
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Override
    public Cliente findById(Integer id) {
        return manager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        System.out.println("Cliente: "+cliente.getId());
        return manager.merge(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Cliente cliente) {
        System.out.println("Cliente: "+cliente.getId());
        cliente = findById(cliente.getId());
        manager.remove(cliente);
    }
}
