package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;

import java.util.List;

public interface TicketPortIn {
    TicketDto enregistrer(TicketDto ticketDto);

    List<TicketDto> lister();

    TicketDto editer(String id);

    void supprimer(String id);

    void liberer(String id);

    void modifier(TicketDto ancienTicket, TicketDto nouveauTicket);

    List<TicketDto> nonAffectes();

    void affecter(String id, String idPersonne);
}
