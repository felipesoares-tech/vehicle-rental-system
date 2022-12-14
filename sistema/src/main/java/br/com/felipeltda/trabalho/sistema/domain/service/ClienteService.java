package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrarCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getCpf())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        clienteRepository.save(cliente);
    }

    public void deletarCliente(Cliente cliente) {
        try{
            clienteRepository.deleteById(cliente.getCpf());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente consultarCliente(String clienteId){
        return clienteRepository.findById(clienteId).orElseThrow(() -> new EntidadeInexistenteException("CPF NÃO ENCONTRADO!"));
    }

}
