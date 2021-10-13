package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortOut {
  PersonneDto enregistrer(PersonneDto personneDto);

  List<PersonneDto> lister();

  void supprimer(String id);

  PersonneDto modifier(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto);

  PersonneDto editer(String id);
}
