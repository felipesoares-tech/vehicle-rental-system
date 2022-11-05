package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarrosRepository carrosRepository;

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> findAll(){
        return carrosRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public Carro findById(@PathVariable String carroId){
        return carrosRepository.findById(carroId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Carro carro){
        try{
            carroService.cadastrarCarro(carro);
            return ResponseEntity.status(HttpStatus.CREATED).body(carro);
        }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLACA INFORMADA JÁ CONSTA NO BANCO DE DADOS");
        }

    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Carro carro){
        try{
            carrosRepository.deleteById(carro.getPlaca());
            return ResponseEntity.status(HttpStatus.OK).body(carro);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA");
        }
    }
}
