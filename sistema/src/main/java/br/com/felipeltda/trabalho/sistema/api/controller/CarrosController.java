package br.com.felipeltda.trabalho.sistema.api.controller;


import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {
    @Autowired
    private CarrosRepository carrosRepository;
    @GetMapping
    public List<Carro> listar(){
        return carrosRepository.listar();
    }

    @GetMapping("/{carroId}")
    public Carro buscar(@PathVariable String carroId){
        return carrosRepository.buscar(carroId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro adicionar (@RequestBody Carro carro){
        return carrosRepository.salvar(carro);
    }
}
