package org.ilona.cafeteria.adapter.out.jpa.repository;

import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneJpaRepository extends JpaRepository<PersonneJpaEntity, String> {
  PersonneJpaEntity findByNomAndPrenomAndCategorie(String nom, String prenom, Categorie categorie);
}
