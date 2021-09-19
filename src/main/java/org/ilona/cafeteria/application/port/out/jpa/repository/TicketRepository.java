package org.ilona.cafeteria.application.port.out.jpa.repository;

import org.ilona.cafeteria.application.port.out.jpa.entities.TicketJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketJpaEntity, String> {
}
