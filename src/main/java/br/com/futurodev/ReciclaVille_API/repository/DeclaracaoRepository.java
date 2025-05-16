package br.com.futurodev.ReciclaVille_API.repository;

import br.com.futurodev.ReciclaVille_API.model.dtos.DashboardResponse;
import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {
    @Query("SELECT new br.com.futurodev.ReciclaVille_API.model.dtos.DashboardResponse(m.nome, SUM(i.toneladasCompensacao)) " +
            "FROM Declaracao d " +
            "JOIN d.itensDeclaracao i " +
            "JOIN i.material m " +
            "GROUP BY m.nome")
    List<DashboardResponse> findDashboardData();
}
