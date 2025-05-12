package br.com.futurodev.ReciclaVille_API.controller;


import br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO.MaterialRequest;
import br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO.MaterialResponse;
import br.com.futurodev.ReciclaVille_API.model.entity.Material;
import br.com.futurodev.ReciclaVille_API.service.MaterialService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Materiais")
public class MaterialController {
    
    @Autowired
    MaterialService materialService;
    
    @Autowired
    ModelMapper modelMapper;
    
    
    @GetMapping
    public ResponseEntity<List<MaterialResponse>> list(){
        List<MaterialResponse> materiais = this.materialService.findAllMaterial().stream()
                .map(material -> modelMapper.map(material, MaterialResponse.class)).collect(Collectors.toList());
        return materiais.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(materiais);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MaterialResponse> getById(@PathVariable Long id){
        Material material = materialService.findMaterialById(id);
        if (material == null ){
            return ResponseEntity.notFound().build();
        }
        MaterialResponse response = modelMapper.map(material, MaterialResponse.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MaterialResponse> create(@RequestBody @Valid MaterialRequest materialDTO) throws Exception{
        Material material = modelMapper.map(materialDTO, Material.class);
        Material newMaterial = materialService.create(material);
        MaterialResponse newMaterialDTO = modelMapper.map(newMaterial, MaterialResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMaterialDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponse> update(@PathVariable Long id, @RequestBody MaterialRequest materialDTO) throws Exception{
        Material material = modelMapper.map(materialDTO, Material.class);
        Material newMaterial = materialService.update(id, material);
        MaterialResponse newMaterialDTO = modelMapper.map(newMaterial, MaterialResponse.class);
        return ResponseEntity.ok(newMaterialDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.materialService.delete(id);
        return ResponseEntity.ok("Material removido com sucesso!");
    }
    
    
}
