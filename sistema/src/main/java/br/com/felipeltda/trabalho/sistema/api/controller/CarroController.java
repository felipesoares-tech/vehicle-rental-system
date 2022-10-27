package br.com.felipeltda.trabalho.sistema.api.controller;


import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarrosRepository carrosRepository;
    @GetMapping
    public List<Carro> findAll(){
        return carrosRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public Carro findById(@PathVariable String carroId){
        return carrosRepository.findById(carroId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro save (@RequestBody Carro carro){
        return carrosRepository.save(carro);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Carro carro){
        carrosRepository.deleteById(carro);
    }
}
