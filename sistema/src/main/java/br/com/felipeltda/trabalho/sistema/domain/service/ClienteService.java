package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.ChavePrimariaException;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        try{
            return clienteRepository.save(cliente);
        }catch (JpaSystemException e){
            throw new ChavePrimariaException("NECESSARIO INFORMAR O CPF!");
        }
    }


}
