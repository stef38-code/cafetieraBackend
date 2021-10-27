package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketJpaEntityMapper {
  TicketJpaEntity to(Ticket ticket);

  TicketJpaEntity to(TicketDto ticketDto);

  /*@IterableMapping(qualifiedByName = "personne")
  List<TicketDto> ticketJpaEntityListToTicketDtoList(List<TicketJpaEntity> tickets );

  @Named("personne")
  @Mapping(target = "personne", ignore = true)
  TicketDto mapWithoutPersonne(TicketJpaEntity source);*/
}
