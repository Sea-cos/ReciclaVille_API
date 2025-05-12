package br.com.futurodev.ReciclaVille_API.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class ItensDeclaracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "declaracao_id")
    private Declaracao declaracao;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(name = "percentual_compensacao")
    private BigDecimal percentualCompensacao;

    @Column(name = "toneladas_declaradas")
    private BigDecimal toneladasDeclaradas;

    @Column(name = "toneladas_compensacao")
    private BigDecimal toneladasCompensacao;


}
