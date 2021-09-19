package org.ilona.cafeteria.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "personne",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class PersonneControler {
    private PersonnePortIn personnePortIn;

    @PostMapping
    public ResponseEntity<PersonneDto> ajoutUnePersonne(PersonneDto personneDto) {
        return new ResponseEntity<>(personnePortIn.ajouterUnePersonne(personneDto),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<PersonneDto>> getToutesLesPersonnes() {
        return new ResponseEntity<>(personnePortIn.getToutesLesPersonnes(), HttpStatus.OK);
    }
}
