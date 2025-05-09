package br.com.futurodev.ReciclaVille_API.model.dtos.clienteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "Nome obrigatório.")
    private String nome;

    @NotBlank(message = "CNPJ obrigatório.")
    @Size(min = 14, max = 14, message = "CNPJ precisa ter exatamente 14 dígitos.")
    private String cnpj;

    private String atividadeEconomica;
    private String responsavel;
}
