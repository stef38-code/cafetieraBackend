package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneDto;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneEntityController;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneResource;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(
    value = "personne",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneControler {
  private final PersonnePortIn personnePortIn;

  @PostMapping
  @CacheEvict(value = "personnes", allEntries = true)
  public ResponseEntity<PersonneDto> enregistrer(@RequestBody @Valid PersonneDto personneDto) {
    return new ResponseEntity<>(personnePortIn.enregistrer(personneDto), HttpStatus.OK);
  }

  @GetMapping
  @Cacheable("personnes")
  public ResponseEntity<Collection<PersonneDto>> lister() {
    return new ResponseEntity<>(personnePortIn.lister(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonneDto> editer(@PathVariable final String id) {
    PersonneDto personne = personnePortIn.editer(id);
    PersonneResource.addLinkByRef(personne);
    return ResponseEntity.ok(personne);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @CacheEvict(value = "personnes", allEntries = true)
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<Void> supprimer(@PathVariable final String id) {
    personnePortIn.supprimer(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  @CacheEvict(value = "personnes", allEntries = true)
  public ResponseEntity<Void> modifier(@RequestBody PersonneEntityController entityController) {
    personnePortIn.modifier(
        entityController.getAnciennePersonne(), entityController.getNouvellePersonne());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
