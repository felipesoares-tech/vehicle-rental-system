package br.com.felipeltda.trabalho.sistema.api.controller;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import br.com.felipeltda.trabalho.sistema.domain.service.OnibusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onibus")
public class OnibusController {
    @Autowired
    private OnibusService onibusService;

    @Autowired
    private OnibusRepository onibusRepository;

    @GetMapping
    public List<Onibus> findAll(){
        return onibusService.listarOnibus();
    }
    @GetMapping("/{onibusId}")
    public Onibus findById(@PathVariable String onibusId){
        return onibusService.consultarOnibus(onibusId);

    }
    @PostMapping
    public ResponseEntity<Object> save (@RequestBody Onibus onibus){
        try{
            onibusService.cadastrarOnibus(onibus);
            return ResponseEntity.status(HttpStatus.CREATED).body(onibus);
        }catch (EntidadeDuplicadaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLACA INFORMADA JÁ CONSTA NO BANCO DE DADOS");
        }

    }
    @DeleteMapping
    public ResponseEntity<Object> deleteById(@RequestBody Onibus onibus){
        try {
            onibusService.deletarOnibus(onibus);
            return ResponseEntity.status(HttpStatus.OK).body(onibus);
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA!");
        }
    }

    @PutMapping("/{onibusId}")
    public ResponseEntity<Object> atualizar(@PathVariable String onibusId, @RequestBody Onibus caminhao){

        try{
            Optional<Onibus> onibusAtual =  onibusRepository.findById(onibusId);
            if (onibusAtual.isPresent()) {
                BeanUtils.copyProperties(caminhao, onibusAtual.get(), "placa");
                Onibus onibusSalvo = onibusRepository.save(onibusAtual.get());
                return ResponseEntity.status(HttpStatus.OK).body(onibusSalvo);
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TESTE");
        }catch (EntidadeInexistenteException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ENTIDADE NÃO ENCONTRADA!");
        }
    }
}
