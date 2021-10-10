package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;

import java.util.List;

public interface PersonnePortOut {
  PersonneDto enregistrer(PersonneDto personneDto);

  List<PersonneDto> toutes();

  void supprimer(PersonneDto personneDto);

  PersonneDto miseAjour(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto);

  PersonneDto unePersonne(String id);
}
