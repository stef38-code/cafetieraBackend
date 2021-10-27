package org.ilona.cafeteria.adapter.out.jpa.repository;

import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketJpaEntity, String> {
  TicketJpaEntity findByNumeroAndMontant(String numero, Integer montant);
}
