package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnibusService {

    @Autowired
    OnibusRepository onibusRepository;

    public void cadastrarOnibus(Onibus onibus) {
        if (onibusRepository.existsById(onibus.getPlaca())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }

        onibusRepository.save(onibus);

    }

    public void deletarOnibus(Onibus onibus){
        try{
            onibusRepository.deleteById(onibus.getPlaca());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }

    public List<Onibus> listarOnibus(){
        return onibusRepository.findAll();
    }

    public Onibus consultarOnibus(String onibusId){
        return onibusRepository.findById(onibusId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
}
