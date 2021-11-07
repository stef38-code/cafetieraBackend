package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.PersonneDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {TicketMapperHelper.class})
public interface PersonneMapper {
  Personne to(PersonneDto personneDto);

  @Mapping(
      target = "nombreTicket",
      source = "tickets",
      qualifiedByName = "compteLesTicketsEntities")
  Personne to(PersonneJpaEntity personneJpaEntity);

  List<Personne> toCollection(List<PersonneJpaEntity> PersonneJpaEntities);
  /** Gestion des informations circulaires */
  @Mapping(target = "personne", ignore = true)
  Ticket ticketJpaEntityToTicket(TicketJpaEntity ticketJpaEntity);

  @Mapping(target = "personnes", ignore = true)
  Categorie categorieJpaEntityToCategorie(CategorieJpaEntity categorieJpaEntity);
}
