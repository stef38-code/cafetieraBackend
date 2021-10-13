package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortIn {
    PersonneDto enregistrer(PersonneDto personneDto);

    List<PersonneDto> lister();

    void supprimer( String id);

    void modifier(PersonneDto anciennnePersonneDto, PersonneDto nouvellePersonneDto);

    PersonneDto editer(String id);
}
