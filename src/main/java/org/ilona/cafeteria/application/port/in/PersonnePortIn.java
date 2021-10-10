package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortIn {
    PersonneDto enregistrer(PersonneDto personneDto);

    List<PersonneDto> toutes();

    void supprimer(PersonneDto personneDto);

    void miseAjour(PersonneDto anciennnePersonneDto, PersonneDto nouvellePersonneDto);

    PersonneDto unePersonne(String id);
}
