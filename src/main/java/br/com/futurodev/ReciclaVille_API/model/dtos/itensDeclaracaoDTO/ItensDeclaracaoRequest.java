package br.com.futurodev.ReciclaVille_API.model.dtos.itensDeclaracaoDTO;


import br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO.MaterialRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensDeclaracaoRequest {

    private Long id;
    private MaterialRequest material; // DTO de material, só com os campos necessários (id, nome, etc)
    private BigDecimal percentualCompensacao; // opcional no request, pode ser calculado no service
    private BigDecimal toneladasDeclaradas;
    // não tem campo Declaracao para evitar ciclo
}
