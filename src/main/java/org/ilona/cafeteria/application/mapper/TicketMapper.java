package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {
  @Mapping(target = "personne.tickets", ignore = true)
  Ticket to(TicketJpaEntity ticketJpaEntity);

  List<Ticket> toCollection(List<TicketJpaEntity> all);

  Ticket to(TicketDto ticketDto);

  @Mapping(target = "personnes", ignore = true)
  Categorie categorieJpaEntityToCategorie(CategorieJpaEntity categorieJpaEntity);
}
