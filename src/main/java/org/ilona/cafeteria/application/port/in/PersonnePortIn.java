package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortIn {
    PersonneDto ajouterUnePersonne(PersonneDto personneDto);

    List<PersonneDto> getToutesLesPersonnes();
}
