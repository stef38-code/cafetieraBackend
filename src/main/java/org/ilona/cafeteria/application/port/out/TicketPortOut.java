package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.port.in.entities.TicketDto;

import java.util.List;

public interface TicketPortOut {
  TicketDto enregistrer(TicketDto ticketDto);

  List<TicketDto> lister();

  TicketDto editer(String id);

  void supprimer(String id);

  void liberer(String id);

  TicketDto modifier(TicketDto ancienTicket, TicketDto nouveauTicket);
}
