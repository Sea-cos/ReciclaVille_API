package br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialRequest {

    @NotBlank(message = "Nome obrigatório.")
    private String nome;
    private Float percentualCompensacao;
}
