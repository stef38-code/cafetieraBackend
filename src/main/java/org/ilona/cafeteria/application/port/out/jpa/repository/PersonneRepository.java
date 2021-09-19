package org.ilona.cafeteria.application.port.out.jpa.repository;

import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<PersonneJpaEntity, String> {
}
