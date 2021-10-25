package org.ilona.cafeteria.application.port.out.jpa.repository;

import org.ilona.cafeteria.application.port.out.jpa.entities.CategorieJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieJpaRepository extends JpaRepository<CategorieJpaEntity, String> {
  CategorieJpaEntity findByNom(String nom);
}
