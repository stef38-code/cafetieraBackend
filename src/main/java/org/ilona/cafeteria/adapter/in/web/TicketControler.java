package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "ticket",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class TicketControler {
    private final TicketPortIn ticketPortIn;

    @PostMapping
    public ResponseEntity<TicketDto> ajoutUnTicket(TicketDto ticketDto) {
        return new ResponseEntity<>(ticketPortIn.ajouterUnTicket(ticketDto),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<TicketDto>> getToutesLesTickets() {
        return new ResponseEntity<>(ticketPortIn.getTousLesTickets(), HttpStatus.OK);
    }
}
