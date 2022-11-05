package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Veiculo;
import br.com.felipeltda.trabalho.sistema.domain.repository.VeiculosRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculosRepository veiculosRepository;

    @Autowired
    VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> findAll(){
        return veiculosRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public Veiculo findById(@PathVariable String veiculoId){
        return veiculosRepository.findById(veiculoId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }

    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Veiculo veiculo){
       try {
           veiculoService.cadastrarVeiculo(veiculo);
           return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
       }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLACA INFORMADA JÁ CONSTA NO BANCO DE DADOS");
       }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Veiculo veiculo){
        try {
            veiculoService.deletarVeiculo(veiculo);
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA!");
        }
    }
}
