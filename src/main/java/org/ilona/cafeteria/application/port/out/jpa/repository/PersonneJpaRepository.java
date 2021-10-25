package org.ilona.cafeteria.application.port.out.jpa.repository;

import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.domaine.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneJpaRepository extends JpaRepository<PersonneJpaEntity, String> {
  PersonneJpaEntity findByNomAndPrenomAndCategorie(String nom, String prenom, Categorie categorie);
}
