package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.CaminhaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoService caminhaoService;

    @Autowired
    private CaminhaoRepository caminhaoRepository;

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

    @PutMapping("/{caminhaoId}")
    public ResponseEntity<Object> atualizar(@PathVariable String caminhaoId, @RequestBody Caminhao caminhao){

        try{
            Optional<Caminhao> caminhaoAtual =  caminhaoRepository.findById(caminhaoId);
            if (caminhaoAtual.isPresent()) {
                BeanUtils.copyProperties(caminhao, caminhaoAtual.get(), "cpf");
                Caminhao caminhaoSalvo = caminhaoRepository.save(caminhaoAtual.get());
                return ResponseEntity.status(HttpStatus.OK).body(caminhaoSalvo);
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TESTE");
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA!");
        }
    }
}
