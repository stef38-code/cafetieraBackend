package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.PersonneDto;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {TicketMapperHelper.class})
public interface PersonneJpaEntityMapper {

  PersonneJpaEntity to(Personne personne);

  PersonneJpaEntity to(PersonneDto personneDto);

  /*@Mapping( target = "nombreTicket",source="tickets", qualifiedByName = "compteLesTickets")
      PersonneDto to(Personne personne);
  */
  @Mapping(target = "personne.tickets", ignore = true)
  Ticket ticketJpaEntityToTicket(TicketJpaEntity ticketJpaEntity);
}
