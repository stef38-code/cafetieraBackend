package org.ilona.cafeteria.adapter.out.jpa.repository;

import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieJpaRepository extends JpaRepository<CategorieJpaEntity, String> {
  CategorieJpaEntity findByNom(String nom);
}
