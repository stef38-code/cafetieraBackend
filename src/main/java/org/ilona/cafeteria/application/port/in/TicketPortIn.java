package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.application.port.in.entities.TicketDto;

import java.util.List;

public interface TicketPortIn {
    TicketDto enregistrer(TicketDto ticketDto);

    List<TicketDto> getTousLesTickets();

    TicketDto editer(String id);

    void supprimer(String id);

    void modifier(TicketDto ancienTicket, TicketDto nouveauTicket);
}
