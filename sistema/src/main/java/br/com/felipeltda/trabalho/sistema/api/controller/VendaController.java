package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.VendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    VendaService vendaService;

    @Autowired
    VendasRepository vendasRepository;

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

    @PutMapping("/{vendaId}")
    public ResponseEntity<Object> atualizar(@PathVariable Integer vendaId, @RequestBody Venda venda){

        try{
            Optional<Venda> vendaAtual =  vendasRepository.findById(vendaId);
            if (vendaAtual.isPresent()) {
                BeanUtils.copyProperties(venda, vendaAtual.get(), "id");
                Venda vendaSalva = vendasRepository.save(vendaAtual.get());
                return ResponseEntity.status(HttpStatus.OK).body(vendaSalva);
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TESTE");
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA!");
        }
    }
}