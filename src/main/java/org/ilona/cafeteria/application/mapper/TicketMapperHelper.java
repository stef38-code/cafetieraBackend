package org.ilona.cafeteria.application.mapper;

import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Component
public class TicketMapperHelper {

  @Named("compteLesTickets")
  public int compteLesTickets(Collection<Ticket> tickets) {
    if (CollectionUtils.isEmpty(tickets)) return 0;
    return tickets.size();
  }

  @Named("compteLesTicketsEntities")
  public int compteLesTickets(List<TicketJpaEntity> tickets) {
    if (CollectionUtils.isEmpty(tickets)) return 0;
    return tickets.size();
  }
}
