package br.com.felipeltda.trabalho.sistema.api.controller;

import br.com.felipeltda.trabalho.sistema.domain.model.Veiculo;
import br.com.felipeltda.trabalho.sistema.domain.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculosRepository veiculosRepository;

    @GetMapping
    public List<Veiculo> findAll(){
        return veiculosRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public Veiculo findById(@PathVariable String clienteId){
        return veiculosRepository.findById(clienteId).orElseThrow(() -> new RuntimeException());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo save (@RequestBody Veiculo cliente){
        return veiculosRepository.save(cliente);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Veiculo cliente){
        veiculosRepository.deleteById(cliente.getPlaca());
    }
}
