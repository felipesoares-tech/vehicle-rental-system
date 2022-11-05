package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Carro;
import br.com.felipeltda.trabalho.sistema.domain.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;

    public Carro cadastrarCarro(Carro carro){
        if (carrosRepository.existsById(carro.getPlaca())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }
       return carrosRepository.save(carro);
    }

    public void deletarCarro(Carro carro){
        try{
            carrosRepository.deleteById(carro.getPlaca());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }

    public List<Carro> listarCarros(){
        return carrosRepository.findAll();
    }

    public Carro consultarCarro(String carroId){
        return carrosRepository.findById(carroId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
}
