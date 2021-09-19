package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TicketService implements TicketPortIn {
    private final TicketPortOut ticketPortOut;

    @Override
    public TicketDto ajouterUnTicket(TicketDto ticketDto) {
        return ticketPortOut.ajouterUnTicket(ticketDto);
    }

    @Override
    public List<TicketDto> getTousLesTickets() {
        return ticketPortOut.toutesLesTickets();
    }
}
