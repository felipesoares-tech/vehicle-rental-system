package br.com.felipeltda.trabalho.sistema.domain.service;

import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeDuplicadaException;
import br.com.felipeltda.trabalho.sistema.domain.exception.EntidadeInexistenteException;
import br.com.felipeltda.trabalho.sistema.domain.model.Veiculo;
import br.com.felipeltda.trabalho.sistema.domain.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VeiculoService {
    @Autowired
    VeiculosRepository veiculosRepository;

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculosRepository.existsById(veiculo.getPlaca())) {
            throw new EntidadeDuplicadaException("ENTIDADE JÁ CADASTRADA");
        }
        veiculosRepository.save(veiculo);
    }

    public void deletarVeiculo(Veiculo veiculo){
        try{
            veiculosRepository.deleteById(veiculo.getPlaca());
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeInexistenteException("ENTIDADE NÃO ENCONTRADA");
        }
    }

    public List<Veiculo> listarVeiculos(){
        return veiculosRepository.findAll();
    }

    public Veiculo consultarVeiculo(String veiculoId){
        return veiculosRepository.findById(veiculoId).orElseThrow(() -> new EntidadeInexistenteException("PLACA NÃO ENCONTRADO!"));
    }
}
