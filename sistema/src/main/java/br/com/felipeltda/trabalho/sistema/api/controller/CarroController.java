package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeNaoEncontrada;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
        return carrosRepository.findById(carroId).orElseThrow(() -> new EntidadeNaoEncontrada("PLACA NÃO ENCONTRADO!"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro save (@RequestBody Carro carro){
        return carroService.cadastrarCarro(carro);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Carro carro){
        carrosRepository.deleteById(carro.getPlaca());
    }
}
