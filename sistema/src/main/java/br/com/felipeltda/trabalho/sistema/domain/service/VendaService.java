package br.com.felipeltda.trabalho.sistema.domain.service;
import br.com.felipeltda.trabalho.sistema.domain.exception.CampoNaoInformadoException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Venda;
import br.com.felipeltda.trabalho.sistema.domain.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VendaService {

    @Autowired
    private VendasRepository vendasRepository;

    public void realizarVenda(Venda venda){
        try{
            vendasRepository.save(venda);
        }catch (DataIntegrityViolationException e){
            throw new CampoNaoInformadoException("CAMPO N INFORMADO!");
        }catch (InvalidDataAccessApiUsageException e){
            throw new EntidadeInexistenteException("ENTIDADE INEXISTENTE");
        }
    }
    public void deletarVenda(Venda venda){
        try{
            vendasRepository.deleteById(venda.getId());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }
    public List<Venda> listarVendas(){
        return vendasRepository.findAll();
    }

    public Venda consultarVenda(Integer vendaId){
        return vendasRepository.findById(vendaId).orElseThrow(() -> new EntidadeInexistenteException("VENDA NÃO ENCONTRADO!"));
    }
}
