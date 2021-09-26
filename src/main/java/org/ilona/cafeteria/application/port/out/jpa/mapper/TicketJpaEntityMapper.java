package org.ilona.cafeteria.application.port.out.jpa.mapper;

import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.domaine.entities.Ticket;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TicketJpaEntityMapper {
    Ticket toTicket(TicketJpaEntity ticketJpaEntity);
    TicketJpaEntity toTicketJpaEntity(Ticket ticket);
    TicketJpaEntity toTicketJpaEntity(TicketDto ticketDto);

    TicketDto toTicketDto(TicketJpaEntity ticketJpaEntity);
    List<TicketDto> toCollectionDeTicketDto(List<TicketJpaEntity> TicketJpaEntities);
}
