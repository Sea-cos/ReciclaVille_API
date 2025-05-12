package br.com.futurodev.ReciclaVille_API.repository;

import br.com.futurodev.ReciclaVille_API.model.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
