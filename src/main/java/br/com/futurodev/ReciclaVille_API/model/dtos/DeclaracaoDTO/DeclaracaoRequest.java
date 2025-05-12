package br.com.futurodev.ReciclaVille_API.model.dtos.DeclaracaoDTO;

import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclaracaoRequest {

    @NotBlank(message = "Precisa ter um cliente")
    private Cliente cliente;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicialPeriodo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "A data final deve ser uma data atual ou no futuro")
    private LocalDate dataFinalPeriodo;

    @NotNull
    private BigDecimal totalMateriais;

    @NotNull
    private BigDecimal totalCompensacao;


}
