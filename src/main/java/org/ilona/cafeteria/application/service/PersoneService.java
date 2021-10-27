package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneDto;
import org.ilona.cafeteria.application.business.PersonneBusiness;
import org.ilona.cafeteria.application.business.PersonneBusinessImpl;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.mapper.PersonneDtoMapper;
import org.ilona.cafeteria.application.mapper.PersonneMapper;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersoneService implements PersonnePortIn {
  private final PersonnePortOut portOut;
  private final PersonneMapper mapper;
  private final PersonneDtoMapper mapperDto;

  @Override
  public PersonneDto enregistrer(PersonneDto personneDto) {
    Personne personne = mapper.to(personneDto); // vient du portIn
    // traitement Bissness  avec portOut
    PersonneBusiness business = new PersonneBusinessImpl(portOut);
    personne = business.enregistrer(personne);
    // retour vers portIn
    return mapperDto.to(personne);
  }

  @Override
  public List<PersonneDto> lister() {
    PersonneBusiness business = new PersonneBusinessImpl(portOut);
    List<Personne> personneList = business.lister();
    /* personneList.forEach(ticketDto -> CategorieResource.addLinkByRef(ticketDto));*/
    return mapperDto.toCollection(personneList);
  }

  @Override
  public void supprimer(final String id) {
    PersonneBusiness business = new PersonneBusinessImpl(portOut);
    Personne personne = business.editer(id);
    business.supprimer(personne);
  }

  @Override
  public void modifier(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto) {
    Personne anciennePersonne = mapper.to(anciennePersonneDto);
    Personne nouvellePersonne = mapper.to(nouvellePersonneDto);
    PersonneBusiness business = new PersonneBusinessImpl(portOut);
    business.modifier(anciennePersonne, nouvellePersonne);
  }

  @Override
  public PersonneDto editer(String id) {
    PersonneBusiness business = new PersonneBusinessImpl(portOut);
    Personne personne = business.editer(id);
    return mapperDto.to(personne);
  }
}
