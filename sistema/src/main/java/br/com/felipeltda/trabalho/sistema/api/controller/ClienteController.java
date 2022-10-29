package br.com.felipeltda.trabalho.sistema.api.controller;

import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clientesId}")
    public Cliente findById(@PathVariable Integer clienteId){
        return clienteRepository.findById(clienteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Cliente cliente){
        clienteRepository.deleteById(cliente);
    }
}
