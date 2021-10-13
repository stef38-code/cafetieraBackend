package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.exceptions.PersoneServiceException;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonResource;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.in.entities.TicketResource;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersoneService implements PersonnePortIn {
  private final PersonnePortOut personnePortOut;

  @Override
  public PersonneDto enregistrer(PersonneDto personneDto) {
    try {
      return personnePortOut.enregistrer(personneDto);
    } catch (Exception e) {
      throw new PersoneServiceException("Erreur Enregistrement", e);
    }
  }

  @Override
  public List<PersonneDto> lister() {
    List<PersonneDto> personnes = personnePortOut.lister();
    PersonResource resource = new PersonResource();
    personnes.forEach(personne -> {
      resource.addLinkByRef(personne);
      personne.getTickets().forEach( ticket -> TicketResource.addLinkByRef(ticket));
    });
    return personnes;
  }

  @Override
  public void supprimer(final String id) {
    personnePortOut.supprimer(id);
  }

  @Override
  public void modifier(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto) {
    personnePortOut.modifier(anciennePersonneDto, nouvellePersonneDto);
  }

  @Override
  public PersonneDto editer(String id) {
    PersonneDto personne = personnePortOut.editer(id);
    PersonResource.addLinkByRef(personne);
    personne.getTickets().forEach(ticket -> TicketResource.addLinkByRef(ticket));
    return personne;
  }
}
