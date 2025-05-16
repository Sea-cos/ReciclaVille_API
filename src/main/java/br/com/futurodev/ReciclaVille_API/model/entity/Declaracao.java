package br.com.futurodev.ReciclaVille_API.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
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
    @OneToMany(mappedBy = "declaracao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // controla a serialização do lado "pai"
    @Builder.Default
    private List<ItensDeclaracao> itensDeclaracao = new ArrayList<>();


}
