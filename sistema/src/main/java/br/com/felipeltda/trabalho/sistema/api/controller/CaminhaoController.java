package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        return caminhaoRepository.findById(caminhaoId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao save (@RequestBody Caminhao caminhao){
        return caminhaoService.cadastrarCaminhao(caminhao);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Caminhao caminhao){
        try{
            caminhaoRepository.deleteById(caminhao.getPlaca());
            return ResponseEntity.status(HttpStatus.OK).body(caminhao);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA");
        }
    }
}
