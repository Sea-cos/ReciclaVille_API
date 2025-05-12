package br.com.futurodev.ReciclaVille_API.service;

import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import br.com.futurodev.ReciclaVille_API.model.exceptions.ResourceNotFoundException;
import br.com.futurodev.ReciclaVille_API.repository.DeclaracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeclaracaoService {

    @Autowired
    DeclaracaoRepository declaracaoRepository;


    //Adicionar validações
    public Declaracao create(Declaracao declaracao){
        declaracao.setDataDeclaracao(LocalDate.now());
        return declaracaoRepository.save(declaracao);
    }

    public List<Declaracao> findAllDeclaracao(){
        return declaracaoRepository.findAll();
    }

    public Declaracao findDeclaracaoById(Long id){
        return declaracaoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Declaracao não encontrado com o ID: " + id));
    }

    public Declaracao update(Long id, Declaracao declaracaoUpd){
        Declaracao declaracao = findDeclaracaoById(id);
        
        declaracao.setCliente(declaracaoUpd.getCliente());
        declaracao.setDataInicialPeriodo(declaracaoUpd.getDataInicialPeriodo());
        declaracao.setDataFinalPeriodo(declaracaoUpd.getDataFinalPeriodo());
        declaracao.setTotalMateriais(declaracaoUpd.getTotalMateriais());
        declaracao.setTotalCompensacao(declaracaoUpd.getTotalCompensacao());

        return declaracaoRepository.save(declaracao);
    }

    public void delete(Long id){
        Declaracao declaracao = findDeclaracaoById(id);
        declaracaoRepository.delete(declaracao);
    }
}
