package br.com.futurodev.ReciclaVille_API.repository;

import br.com.futurodev.ReciclaVille_API.model.entity.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {

}
