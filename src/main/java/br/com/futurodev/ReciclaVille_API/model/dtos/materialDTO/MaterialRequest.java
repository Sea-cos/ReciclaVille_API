package br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRequest {


    private Long id;
    @NotBlank(message = "Nome obrigatório.")
    private String nome;
    private Float percentualCompensacao;
}
