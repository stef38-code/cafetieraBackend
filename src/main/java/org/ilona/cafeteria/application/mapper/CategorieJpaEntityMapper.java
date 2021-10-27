package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategorieJpaEntityMapper {

  CategorieJpaEntity to(Categorie categorie);

  CategorieJpaEntity to(CategorieDto categorieDto);

  @Mapping(target = "TicketJpaEntity.personne", ignore = true)
  Ticket ticketJpaEntityToTicket(TicketJpaEntity ticketJpaEntity);

  @Mapping(target = "personneJpaEntity.tickets", ignore = true)
  Personne personneJpaEntityToPersonne(PersonneJpaEntity personneJpaEntity);
}
