package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortOut {
 PersonneDto ajouterUnePersonne(PersonneDto personneDto);
 List<PersonneDto> toutesLesPersonnes();
}
