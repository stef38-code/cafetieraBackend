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
    public TicketDto enregistrer(TicketDto ticketDto) {
        return ticketPortOut.enregistrer(ticketDto);
    }

    @Override
    public List<TicketDto> getTousLesTickets() {
        return ticketPortOut.lister();
    }

    @Override
    public TicketDto editer(String id) {
        return ticketPortOut.editer( id);
    }

    @Override
    public void supprimer(String id) {
        ticketPortOut.supprimer( id);
    }

    @Override
    public void modifier(TicketDto ancienTicket, TicketDto nouveauTicket) {
        ticketPortOut.modifier( ancienTicket,  nouveauTicket);
    }
}
