package br.com.futurodev.ReciclaVille_API.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {
    private String material;
    private BigDecimal totalToneladasCompensacao;
}
