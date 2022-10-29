package br.com.felipeltda.trabalho.sistema.api.controller;

import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    VendasRepository vendasRepository;

    @GetMapping
    public List<Venda> findAll(){
        return vendasRepository.findAll();
    }

    @GetMapping("/{vendaId}")
    public Venda findById(@PathVariable Integer vendaId){
        return vendasRepository.findById(vendaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda save (@RequestBody Venda venda){
        return vendasRepository.save(venda);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Venda venda){
        vendasRepository.deleteById(venda);
    }
}
