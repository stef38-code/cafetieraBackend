package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieEntityController;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieResource;
import org.ilona.cafeteria.application.port.in.CategoriePortIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(
        value = "categories",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Slf4j
public class CategorieControler extends Controler<CategorieDto, CategorieEntityController> {
  private final CategoriePortIn categoriePortIn;

  @PostMapping
//  @CacheEvict(value = "categories", allEntries = true)
  public ResponseEntity<CategorieDto> enregistrer(@RequestBody CategorieDto categorieDto) {

    return new ResponseEntity<>(categoriePortIn.enregistrer(categorieDto), HttpStatus.OK);
  }

  @GetMapping
//  @Cacheable("categories")
  public ResponseEntity<Collection<CategorieDto>> lister() {
    return new ResponseEntity<>(categoriePortIn.lister(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategorieDto> editer(@PathVariable final String id) {
    CategorieDto categorieDto = categoriePortIn.editer(id);
    CategorieResource.addLinkByRef(categorieDto);
    return ResponseEntity.ok(categorieDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
//  @CacheEvict(value = "categories", allEntries = true)
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<Void> supprimer(@PathVariable final String id) {
    categoriePortIn.supprimer(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
//  @CacheEvict(value = "categories", allEntries = true)
  public ResponseEntity<Void> modifier(@RequestBody CategorieEntityController entityController) {
    categoriePortIn.modifier(
        entityController.getAncienneCategorie(), entityController.getNouvelleCategorie());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
