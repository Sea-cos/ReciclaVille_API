package br.com.futurodev.ReciclaVille_API.model.dtos.declaracaoDTO;

import br.com.futurodev.ReciclaVille_API.model.dtos.clienteDTO.ClienteResponse;
import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclaracaoResponse {

    private Long id;
    private ClienteResponse cliente;
    private LocalDate dataDeclaracao;
    private LocalDate dataInicialPeriodo;
    private LocalDate dataFinalPeriodo;
    private BigDecimal totalMateriais;
    private BigDecimal totalCompensacao;
}
