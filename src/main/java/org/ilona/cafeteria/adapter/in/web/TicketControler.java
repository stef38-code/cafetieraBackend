package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.in.entities.TicketEntityController;
import org.ilona.cafeteria.application.port.in.entities.TicketResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(
    value = "ticket",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class TicketControler {
  private final TicketPortIn ticketPortIn;

  @GetMapping("/{id}")
  public ResponseEntity<TicketDto> get(@PathVariable final String id) {
    TicketDto ticketDto = ticketPortIn.editer(id);
    TicketResource.addLinkByRef(ticketDto);
    return ResponseEntity.ok(ticketDto);
  }

  @PostMapping
  public ResponseEntity<TicketDto> ajoutUnTicket(TicketDto ticketDto) {
    return new ResponseEntity<>(ticketPortIn.enregistrer(ticketDto), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Collection<TicketDto>> lister() {
    return new ResponseEntity<>(ticketPortIn.getTousLesTickets(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<Void> supprimer(@PathVariable final String id) {
    ticketPortIn.supprimer(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/liberer/{id}")
  @ResponseStatus(HttpStatus.OK)
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<Void> liberer(@PathVariable final String id) {
    ticketPortIn.liberer(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Void> modifier(@RequestBody TicketEntityController entityController) {
    ticketPortIn.modifier(entityController.getAncienTicket(), entityController.getNouveauTicket());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
