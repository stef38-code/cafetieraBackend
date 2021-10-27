package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.in.web.entities.PersonneResource;
import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;
import org.ilona.cafeteria.adapter.in.web.entities.TicketResource;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class TicketDtoMapper {
  public abstract TicketDto to(TicketJpaEntity ticketJpaEntity);

  public abstract List<TicketDto> toCollection(List<Ticket> TicketJpaEntities);

  public abstract TicketDto to(Ticket ticket);

  @AfterMapping
  protected void addLinkByRef(@MappingTarget TicketDto target) {
    if (Objects.nonNull(target)) {
      TicketResource.addLinkByRef(target);
      if (Objects.nonNull(target.getPersonne())) {
        PersonneResource.addLinkByRef(target.getPersonne());
      }
    }
  }
}
