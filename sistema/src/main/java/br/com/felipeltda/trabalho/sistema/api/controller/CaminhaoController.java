package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeNaoEncontrada;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping
    public List<Caminhao> findAll(){
        return caminhaoRepository.findAll();
    }

    @GetMapping("/{caminhaoId}")
    public Caminhao findById(@PathVariable String caminhaoId){
        return caminhaoRepository.findById(caminhaoId).orElseThrow(() -> new EntidadeNaoEncontrada("PLACA NÃO ENCONTRADO!"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao save (@RequestBody Caminhao caminhao){
        return caminhaoService.cadastrarCaminhao(caminhao);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Caminhao caminhao){
        caminhaoRepository.deleteById(caminhao.getPlaca());
    }
}
