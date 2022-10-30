package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeNaoEncontrada;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onibus")
public class OnibusController {

    @Autowired
    private OnibusRepository onibusRepository;

    @Autowired
    private OnibusService onibusService;

    @GetMapping
    public List<Onibus> findAll(){
        return onibusRepository.findAll();
    }

    @GetMapping("/{onibusId}")
    public Onibus findById(@PathVariable String onibusId){
        return onibusRepository.findById(onibusId).orElseThrow(() -> new EntidadeNaoEncontrada("PLACA NÃO ENCONTRADO!"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Onibus save (@RequestBody Onibus onibus){
        return onibusService.cadastrarOnibus(onibus);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Onibus onibus){
        onibusRepository.deleteById(onibus.getPlaca());
    }
}
