package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersoneService implements PersonnePortIn {
    private final PersonnePortOut personnePortOut;

    @Override
    public PersonneDto ajouterUnePersonne(PersonneDto personneDto) {
        return personnePortOut.ajouterUnePersonne(personneDto);
    }

    @Override
    public List<PersonneDto> getToutesLesPersonnes() {
        return personnePortOut.toutesLesPersonnes();
    }

    @Override
    public void getSupprimerUnePersonne(PersonneDto personneDto) {

    }

    @Override
    public void getMiseAjourUnePersonne(PersonneDto personneDto) {

    }
}
