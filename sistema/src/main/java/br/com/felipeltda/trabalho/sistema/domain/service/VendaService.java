package br.com.felipeltda.trabalho.sistema.domain.service;
import br.com.felipeltda.trabalho.sistema.domain.exception.ChavePrimariaException;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VeiculosRepository;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;


@Service
public class VendaService {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VeiculosRepository veiculosRepository;

    public Venda realizarVenda(Venda venda){
        try {
            return vendasRepository.save(venda);
        }catch (JpaSystemException e){
            throw new ChavePrimariaException("NECESSARIO INFORMAR A PLACA!");
        }
    }
}
