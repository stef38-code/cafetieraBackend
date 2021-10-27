package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
  Categorie to(CategorieDto categorieDto);

  Categorie to(CategorieJpaEntity categorieJpaEntity);

  List<Categorie> toCollection(List<CategorieJpaEntity> categorieJpaEntities);

  @Mapping(target = "categorie", ignore = true)
  @Mapping(target = "tickets", ignore = true)
  Personne personneJpaEntityToPersonne(PersonneJpaEntity personneJpaEntity);

  /*@Mapping(target = "TicketJpaEntity.personne", ignore = true)
  Ticket ticketJpaEntityToTicket(TicketJpaEntity ticketJpaEntity );
  @Mapping(target = "personneJpaEntity.tickets", ignore = true)
  Personne personneJpaEntityToPersonne(PersonneJpaEntity personneJpaEntity);*/

}
