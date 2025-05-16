package br.com.futurodev.ReciclaVille_API.model.dtos.declaracaoDTO;

import br.com.futurodev.ReciclaVille_API.model.dtos.itensDeclaracaoDTO.ItensDeclaracaoRequest;
import br.com.futurodev.ReciclaVille_API.model.entity.Cliente;
import br.com.futurodev.ReciclaVille_API.model.entity.ItensDeclaracao;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclaracaoRequest {

    @NotNull(message = "Precisa ter um cliente")
    private Cliente cliente;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicialPeriodo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinalPeriodo;

    private List<ItensDeclaracaoRequest> itensDeclaracao;


}
