package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.ChavePrimariaException;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;

    public Carro cadastrarCarro(Carro carro){
        try{
            return carrosRepository.save(carro);
        }catch (JpaSystemException e){
            throw new ChavePrimariaException("NECESSARIO INFORMAR A PLACA!");
        }
    }
}
