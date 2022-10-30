package br.com.felipeltda.trabalho.sistema.domain.service;
import br.com.felipeltda.trabalho.sistema.domain.exception.ChavePrimariaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao cadastrarCaminhao(Caminhao caminhao){
        if (caminhaoRepository.existsById(caminhao.getPlaca())){
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        try{
            return caminhaoRepository.save(caminhao);
        }catch (JpaSystemException e){
            throw new ChavePrimariaException("NECESSARIO INFORMAR A PLACA!");
        }

    }

}
