package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OnibusService {

    @Autowired
    OnibusRepository onibusRepository;

    public Onibus cadastrarOnibus(Onibus onibus) {
        if (onibusRepository.existsById(onibus.getPlaca())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        return onibusRepository.save(onibus);

    }

    public void deletarOnibus(Onibus onibus){
        try{
            onibusRepository.deleteById(onibus.getPlaca());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }
}
