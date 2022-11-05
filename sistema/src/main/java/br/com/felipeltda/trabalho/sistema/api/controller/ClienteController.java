package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Cliente;
import br.com.felipeltda.trabalho.sistema.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{clienteId}")
    public Cliente findById(@PathVariable String clienteId){
        return clienteService.consultarCliente(clienteId);
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Cliente cliente){
        try{
            clienteService.cadastrarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF INFORMADO JÁ CONSTA NO BANCO DE DADOS");
        }

    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Cliente cliente){
        try{
            clienteService.deletarCliente(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA");
        }
    }
}
