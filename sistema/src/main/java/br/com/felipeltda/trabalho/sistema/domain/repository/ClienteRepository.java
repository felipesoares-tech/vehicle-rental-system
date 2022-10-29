package br.com.felipeltda.trabalho.sistema.domain.repository;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {

    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    void deleteById(Cliente cliente);
}
