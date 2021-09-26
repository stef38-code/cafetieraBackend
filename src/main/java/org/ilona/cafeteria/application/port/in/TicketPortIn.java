package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.application.port.in.entities.TicketDto;

import java.util.List;

public interface TicketPortIn {
    TicketDto ajouterUnTicket(TicketDto ticketDto);

    List<TicketDto> getTousLesTickets();
}
