package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhoesController {
    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @CrossOrigin
    @GetMapping
    public List<Caminhao> listar(){
        return caminhaoRepository.listar();
    }

    @GetMapping("/{caminhaoId}")
    public Caminhao buscar(@PathVariable String caminhaoId){
        return caminhaoRepository.buscar(caminhaoId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao adicionar (@RequestBody Caminhao caminhao){
        return caminhaoRepository.salvar(caminhao);
    }
}
