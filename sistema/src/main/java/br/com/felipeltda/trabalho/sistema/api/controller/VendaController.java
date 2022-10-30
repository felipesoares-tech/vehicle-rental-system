package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    VendasRepository vendasRepository;
    @Autowired
    VendaService vendaService;

    @GetMapping
    public List<Venda> findAll(){
        return vendasRepository.findAll();
    }

    @GetMapping("/{vendaId}")
    public Venda findById(@PathVariable Integer vendaId){
        return vendasRepository.findById(vendaId)
                .orElseThrow(() -> new EntidadeInexistenteException("VENDA NÃO ENCONTRADO!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda save (@RequestBody Venda venda){
        return vendaService.realizarVenda(venda);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Venda venda){
        vendasRepository.deleteById(venda.getId());
    }
}