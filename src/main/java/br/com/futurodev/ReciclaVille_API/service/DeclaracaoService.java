package br.com.futurodev.ReciclaVille_API.service;

import br.com.futurodev.ReciclaVille_API.model.entity.*;
import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import br.com.futurodev.ReciclaVille_API.model.exceptions.ResourceNotFoundException;
import br.com.futurodev.ReciclaVille_API.repository.ClienteRepository;
import br.com.futurodev.ReciclaVille_API.repository.DeclaracaoRepository;
import br.com.futurodev.ReciclaVille_API.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeclaracaoService {

    @Autowired
    DeclaracaoRepository declaracaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MaterialRepository materialRepository;

    public Declaracao create(Declaracao declaracao) throws Exception {
        if (declaracao.getItensDeclaracao() == null) {
            declaracao.setItensDeclaracao(new ArrayList<>());
        }

        Long clienteId = declaracao.getCliente().getId();
        Optional<Cliente> maybeCliente = clienteRepository.findById(clienteId);
        if (maybeCliente.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado com o ID: " + clienteId);
        }
        Cliente cliente = maybeCliente.get();
        declaracao.setCliente(cliente);
        System.out.println("Cliente no declaracao: " + declaracao.getCliente());
        declaracao.setDataDeclaracao(LocalDate.now());

        if (declaracao.getDataInicialPeriodo().isAfter(declaracao.getDataFinalPeriodo()) ||
                declaracao.getDataInicialPeriodo().isEqual(declaracao.getDataFinalPeriodo())) {
            throw new RuntimeException("Data inicial do período deve ser menor que a data final.");
        }

        BigDecimal totalMateriais = BigDecimal.ZERO;
        BigDecimal totalCompensacao = BigDecimal.ZERO;

        for (ItensDeclaracao item : declaracao.getItensDeclaracao()) {
            item.setDeclaracao(declaracao);

            Long materialId = item.getMaterial().getId();
            Optional<Material> maybeMaterial = materialRepository.findById(materialId);
            if (!maybeMaterial.isPresent()){
                throw new ResourceNotFoundException("Material não encontrado com ID " + materialId);
            }
            Material material = maybeMaterial.get();

            item.setMaterial(material);

            item.setPercentualCompensacao(material.getPercentualCompensacao());

            if (item.getToneladasDeclaradas().compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception("Toneladas declaradas devem ser maiores que zero.");
            }

            BigDecimal toneladasCompensacao = item.getToneladasDeclaradas()
                    .multiply(item.getPercentualCompensacao())
                    .divide(new BigDecimal("100"), RoundingMode.HALF_UP);
            item.setToneladasCompensacao(toneladasCompensacao);

            totalMateriais = totalMateriais.add(item.getToneladasDeclaradas());
            totalCompensacao = totalCompensacao.add(toneladasCompensacao);
        }

        declaracao.setTotalMateriais(totalMateriais);
        declaracao.setTotalCompensacao(totalCompensacao);

        System.out.println("Itens na declaracao: " + declaracao.getItensDeclaracao());

        return declaracaoRepository.save(declaracao);
    }

    public List<Declaracao> findAllDeclaracao(){
        return declaracaoRepository.findAll();
    }

    public Declaracao findDeclaracaoById(Long id){
        return declaracaoRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Declaracao não encontrado com o ID: " + id));
    }

    public void delete(Long id){
        Declaracao declaracao = findDeclaracaoById(id);
        declaracaoRepository.delete(declaracao);
    }
}
