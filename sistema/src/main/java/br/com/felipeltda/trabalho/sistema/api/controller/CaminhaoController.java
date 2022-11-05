package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping
    public List<Caminhao> findAll(){
        return caminhaoService.listarCaminhoes();
    }

    @GetMapping("/{caminhaoId}")
    public Caminhao findById(@PathVariable String caminhaoId){
        return caminhaoService.consultarCaminhao(caminhaoId);
    }
    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Caminhao caminhao){
        try{
            caminhaoService.cadastrarCaminhao(caminhao);
            return ResponseEntity.status(HttpStatus.CREATED).body(caminhao);
        }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLACA INFORMADA JÁ CONSTA NO BANCO DE DADOS");
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Caminhao caminhao){
        try{
            caminhaoService.deletarCaminhao(caminhao);
            return ResponseEntity.status(HttpStatus.OK).body(caminhao);
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE INEXISTENTE");
        }
    }
}
