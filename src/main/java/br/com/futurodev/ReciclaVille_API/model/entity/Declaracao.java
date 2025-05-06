package br.com.futurodev.ReciclaVille_API.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Declaracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataDeclaracao;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataInicialPeriodo;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataFinalPeriodo;
    @Column
    private BigDecimal totalMateriais;
    @Column
    private BigDecimal totalCompensacao;


}
