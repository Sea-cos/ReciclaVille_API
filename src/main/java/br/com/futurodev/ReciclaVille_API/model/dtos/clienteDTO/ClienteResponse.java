package br.com.futurodev.ReciclaVille_API.model.dtos.clienteDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private Long CNPJ;
    private String atividadeEconomica;
    private String responsavel;
}
