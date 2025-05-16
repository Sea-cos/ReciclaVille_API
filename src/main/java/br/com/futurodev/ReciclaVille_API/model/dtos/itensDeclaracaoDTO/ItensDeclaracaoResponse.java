package br.com.futurodev.ReciclaVille_API.model.dtos.itensDeclaracaoDTO;


import br.com.futurodev.ReciclaVille_API.model.dtos.materialDTO.MaterialResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensDeclaracaoResponse {

    private Long id;
    private MaterialResponse material;
    private BigDecimal percentualCompensacao;
    private BigDecimal toneladasDeclaradas;
    private BigDecimal toneladasCompensacao;
    // sem referência para Declaracao
}
