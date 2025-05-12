package br.com.futurodev.ReciclaVille_API.model.dtos.DeclaracaoDTO;

import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DeclaracaoResponse {

    private Long id;
    private Cliente cliente;
    private LocalDate dataDeclaracao;
    private LocalDate dataInicialPeriodo;
    private LocalDate dataFinalPeriodo;
    private BigDecimal totalMateriais;
    private BigDecimal totalCompensacao;
}
