package br.com.felipeltda.trabalho.sistema.api.controller;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeNaoEncontrada;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.repository.ClienteRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public Cliente findById(@PathVariable String clienteId){
        return clienteRepository.findById(clienteId).orElseThrow(() -> new EntidadeNaoEncontrada("CPF NÃO ENCONTRADO!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Cliente cliente){
        clienteRepository.deleteById(cliente.getCpf());
    }
}
