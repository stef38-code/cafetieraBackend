package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;
import org.ilona.cafeteria.adapter.in.web.entities.TicketEntityController;
import org.ilona.cafeteria.adapter.in.web.entities.TicketResource;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
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
@Slf4j
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

    @PostMapping("/{id}/affecter/{idPersonne}")
    public ResponseEntity<Void> affecterUnTicket(@PathVariable String id, @PathVariable String idPersonne) {
        //  log.info("=======ticket[{}]=========idPerson[{}]===================",id,idPersonne);
        ticketPortIn.affecter(id, idPersonne);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<TicketDto>> lister() {
        return new ResponseEntity<>(ticketPortIn.lister(), HttpStatus.OK);
    }

    @GetMapping("/nonAffectes")
    public ResponseEntity<Collection<TicketDto>> nonAffectes() {
        return new ResponseEntity<>(ticketPortIn.nonAffectes(), HttpStatus.OK);
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
