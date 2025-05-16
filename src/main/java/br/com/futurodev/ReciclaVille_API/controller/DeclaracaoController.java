package br.com.futurodev.ReciclaVille_API.controller;

import br.com.futurodev.ReciclaVille_API.model.dtos.declaracaoDTO.DeclaracaoResponse;
import br.com.futurodev.ReciclaVille_API.model.dtos.declaracaoDTO.DeclaracaoRequest;
import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import br.com.futurodev.ReciclaVille_API.model.entity.ItensDeclaracao;
import br.com.futurodev.ReciclaVille_API.model.entity.Material;
import br.com.futurodev.ReciclaVille_API.service.DeclaracaoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Declaracoes")
public class DeclaracaoController {

    @Autowired
    private DeclaracaoService declaracaoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DeclaracaoResponse>> list(){
        List<DeclaracaoResponse> declaracoes = this.declaracaoService.findAllDeclaracao().stream()
                .map(declaracao -> modelMapper.map(declaracao, DeclaracaoResponse.class)).collect(Collectors.toList());
        return declaracoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(declaracoes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DeclaracaoResponse> getById(@PathVariable Long id){
        Declaracao declaracao = declaracaoService.findDeclaracaoById(id);
        if (declaracao == null ){
            return ResponseEntity.notFound().build();
        }
        DeclaracaoResponse response = modelMapper.map(declaracao, DeclaracaoResponse.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DeclaracaoResponse> create(@RequestBody @Valid DeclaracaoRequest declaracaoDTO) throws Exception{
        Declaracao declaracao = modelMapper.map(declaracaoDTO, Declaracao.class);
        List<ItensDeclaracao> itens = declaracaoDTO.getItensDeclaracao().stream().map(reqItem -> {
            ItensDeclaracao item = new ItensDeclaracao();
            Material material = new Material();
            material.setId(reqItem.getMaterial().getId());
            item.setMaterial(material);
            item.setToneladasDeclaradas(reqItem.getToneladasDeclaradas());
            return item;
        }).collect(Collectors.toList());
        Declaracao newDeclaracao = declaracaoService.create(declaracao);
        DeclaracaoResponse newDeclaracaoDTO = modelMapper.map(newDeclaracao, DeclaracaoResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDeclaracaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.declaracaoService.delete(id);
        return ResponseEntity.ok("Declaracao removida com sucesso!");
    }
}
