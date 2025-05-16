package br.com.futurodev.ReciclaVille_API.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
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
    @JsonBackReference  // para evitar serializar o objeto pai novamente
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
