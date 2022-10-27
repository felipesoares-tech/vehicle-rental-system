package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @GetMapping
    public List<Caminhao> findAll(){
        return caminhaoRepository.findAll();
    }

    @GetMapping("/{caminhaoId}")
    public Caminhao findById(@PathVariable String caminhaoId){
        return caminhaoRepository.findById(caminhaoId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao save (@RequestBody Caminhao caminhao){
        return caminhaoRepository.save(caminhao);
    }
}
