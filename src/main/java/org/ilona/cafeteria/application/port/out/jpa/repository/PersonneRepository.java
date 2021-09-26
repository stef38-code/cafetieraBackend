package org.ilona.cafeteria.application.port.out.jpa.repository;

import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<PersonneJpaEntity, String> {
    PersonneJpaEntity findByNomAndPrenomAndNumero(String nom,String prenom,String numero);
}
