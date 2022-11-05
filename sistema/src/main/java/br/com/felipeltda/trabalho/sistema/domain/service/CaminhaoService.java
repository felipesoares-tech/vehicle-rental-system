package br.com.felipeltda.trabalho.sistema.domain.service;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public void cadastrarCaminhao(Caminhao caminhao){
        if (caminhaoRepository.existsById(caminhao.getPlaca())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }
        caminhaoRepository.save(caminhao);

    }

    public void deletarCaminhao(Caminhao caminhao){
        try{
            caminhaoRepository.deleteById(caminhao.getPlaca());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }

    public List<Caminhao> listarCaminhoes(){
        return caminhaoRepository.findAll();
    }

    public Caminhao consultarCaminhao(String caminhaoId){
        return caminhaoRepository.findById(caminhaoId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
}
