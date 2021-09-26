package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(
    value = "personne",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneControler {
  private final PersonnePortIn personnePortIn;

  @PostMapping
  public ResponseEntity<PersonneDto> ajoutUnePersonne(@RequestBody PersonneDto personneDto) {
    return new ResponseEntity<>(personnePortIn.ajouterUnePersonne(personneDto), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Collection<PersonneDto>> getToutesLesPersonnes() {
    return new ResponseEntity<>(personnePortIn.getToutesLesPersonnes(), HttpStatus.OK);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity getSupprimerUnePersonne(@RequestBody PersonneDto personneDto) {
    personnePortIn.getSupprimerUnePersonne(personneDto);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity getMiseAjourUnePersonne(@RequestBody PersonneDto personneDto) {
    personnePortIn.getMiseAjourUnePersonne(personneDto);
    return new ResponseEntity(HttpStatus.OK);
  }
}
