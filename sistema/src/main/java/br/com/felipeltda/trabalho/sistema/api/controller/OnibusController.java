package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onibus")
public class OnibusController {

    @Autowired
    OnibusRepository onibusRepository;

    @GetMapping
    public List<Onibus> findAll(){
        return onibusRepository.findAll();
    }

    @GetMapping("/{onibusId}")
    public Optional<Onibus> findById(@PathVariable String onibusId){
        return onibusRepository.findById(onibusId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Onibus save (@RequestBody Onibus onibus){
        return onibusRepository.save(onibus);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Onibus onibus){
        onibusRepository.deleteById(onibus.getPlaca());
    }
}
