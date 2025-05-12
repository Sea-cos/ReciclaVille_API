package br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialResponse {

    private Long id;
    private String nome;
    private Float percentualCompensacao;
}
