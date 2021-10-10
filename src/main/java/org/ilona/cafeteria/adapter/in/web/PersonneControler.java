package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonResource;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.in.entities.PersonneEntityController;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
  @CacheEvict(value="personnes", allEntries=true)
  public ResponseEntity<PersonneDto> ajoutUnePersonne(@RequestBody PersonneDto personneDto) {
    return new ResponseEntity<>(personnePortIn.enregistrer(personneDto), HttpStatus.OK);
  }

  @GetMapping
  @Cacheable("personnes")
  public ResponseEntity<Collection<PersonneDto>> getToutesLesPersonnes() {
    return new ResponseEntity<>(personnePortIn.toutes(), HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<PersonneDto> get(@PathVariable final String id) {
    PersonneDto personne = personnePortIn.unePersonne(id);

    PersonResource resource = new PersonResource(personne);
    return ResponseEntity.ok(resource.addLink(id));
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  @CacheEvict(value="personnes", allEntries=true)
  public ResponseEntity<Void> getSupprimerUnePersonne(@RequestBody PersonneDto personneDto) {
    personnePortIn.supprimer(personneDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  @CacheEvict(value="personnes", allEntries=true)
  public ResponseEntity<Void> getMiseAjourUnePersonne(@RequestBody PersonneEntityController entityController) {
    personnePortIn.miseAjour(entityController.getAnciennePersonne(),entityController.getNouvellePersonne());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
