package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonneResource;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.in.entities.TicketResource;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TicketService implements TicketPortIn {
  private final TicketPortOut ticketPortOut;

  @Override
  public TicketDto enregistrer(TicketDto ticketDto) {
    return ticketPortOut.enregistrer(ticketDto);
  }

  @Override
  public List<TicketDto> getTousLesTickets() {
    List<TicketDto> ticketDtoList = ticketPortOut.lister();
    ticketDtoList.forEach(
        ticketDto -> {
          TicketResource.addLinkByRef(ticketDto);
          if (Objects.nonNull(ticketDto.getPersonne()))
            PersonneResource.addLinkByRef(ticketDto.getPersonne());
        });
    return ticketDtoList;
  }

  @Override
  public TicketDto editer(String id) {
    TicketDto ticketDto = ticketPortOut.editer(id);
    TicketResource.addLinkByRef(ticketDto);
    if (Objects.nonNull(ticketDto.getPersonne()))
      PersonneResource.addLinkByRef(ticketDto.getPersonne());
    return ticketDto;
  }

  @Override
  public void supprimer(String id) {
    ticketPortOut.supprimer(id);
  }

  @Override
  public void liberer(String id) {}

  @Override
  public void modifier(TicketDto ancienTicket, TicketDto nouveauTicket) {
    ticketPortOut.modifier(ancienTicket, nouveauTicket);
  }
}
