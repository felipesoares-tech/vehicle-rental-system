package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    VendaService vendaService;

    @GetMapping
    public List<Venda> findAll(){
        return vendaService.listarVendas();
    }

    @GetMapping("/{vendaId}")
    public Venda findById(@PathVariable Integer vendaId){
        return vendaService.consultarVenda(vendaId);
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Venda venda){
        vendaService.realizarVenda(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Venda venda){
        try {
            vendaService.deletarVenda(venda);
            return ResponseEntity.status(HttpStatus.OK).body(venda);
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VENDA NÃO ENCONTRADA!");
        }
    }
}