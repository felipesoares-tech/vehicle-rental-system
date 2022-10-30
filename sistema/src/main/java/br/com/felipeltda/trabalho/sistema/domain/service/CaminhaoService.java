package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.model.Caminhao;
import br.com.felipeltda.trabalho.sistema.domain.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao cadastrarCaminhao(Caminhao caminhao){
        return caminhaoRepository.save(caminhao);
    }

}
