package br.com.futurodev.ReciclaVille_API.service;

import br.com.futurodev.ReciclaVille_API.model.entity.Material;
import br.com.futurodev.ReciclaVille_API.model.exceptions.ResourceNotFoundException;
import br.com.futurodev.ReciclaVille_API.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Material create(Material material){
        return materialRepository.save(material);
    }

    public List<Material> findAllMaterial(){
        return materialRepository.findAll();
    }

    public Material findMaterialById(Long id){
        return materialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Material não encontrado com o ID: " + id));
    }

    public Material update(Long id, Material materialUpd){
        Material material = findMaterialById(id);

        material.setNome(materialUpd.getNome());
        material.setPercentualCompensacao(materialUpd.getPercentualCompensacao());
        return materialRepository.save(material);
    }

    public void delete(Long id){
        Material material = findMaterialById(id);
        materialRepository.delete(material);
    }
}
