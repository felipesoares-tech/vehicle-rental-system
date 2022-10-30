package br.com.felipeltda.trabalho.sistema.domain.service;
import br.com.felipeltda.trabalho.sistema.domain.exception.ChavePrimariaException;
import br.com.felipeltda.trabalho.sistema.domain.model.Onibus;
import br.com.felipeltda.trabalho.sistema.domain.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class OnibusService {

    @Autowired
    OnibusRepository onibusRepository;

    public Onibus cadastrarOnibus(Onibus onibus){

        try{
            return onibusRepository.save(onibus);
        }catch (JpaSystemException e){
            throw new ChavePrimariaException("NECESSARIO INFORMAR A PLACA!");
        }

    }
}
