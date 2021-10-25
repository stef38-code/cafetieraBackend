package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.jpa.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.PersonneJpaRepository;
import org.ilona.cafeteria.domaine.business.PersonneBusiness;
import org.ilona.cafeteria.domaine.entities.Personne;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PersonneAdapterOut implements PersonnePortOut {
  private final PersonneJpaRepository personneJpaRepository;
  private final PersonneJpaEntityMapper personneMapper;

  @Override
  public PersonneDto enregistrer(PersonneDto personneDto) {
    PersonneBusiness business = new PersonneBusiness(personneJpaRepository, personneMapper);
    Personne personne = personneMapper.toPersonne(personneDto);
    personne = business.enregistrer(personne);
    return personneMapper.toPersonneDto(personne);
  }

  @Override
  @Transactional
  public List<PersonneDto> lister() {
    PersonneBusiness business = new PersonneBusiness(personneJpaRepository, personneMapper);
    return personneMapper.withBusinesstoCollectionDePersonneDto(business.lister());
  }

  @Override
  public void supprimer(String id) {
    PersonneBusiness business = new PersonneBusiness(personneJpaRepository, personneMapper);
    Personne personne = business.editer(id);
    business.supprimer(personne);
  }

  @Override
  public PersonneDto modifier(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto) {
    PersonneBusiness business = new PersonneBusiness(personneJpaRepository, personneMapper);
    Personne anciennePersonne = personneMapper.toPersonne(anciennePersonneDto);
    Personne nouvellePersonne = personneMapper.toPersonne(nouvellePersonneDto);
    return personneMapper.toPersonneDto(business.modifier(anciennePersonne, nouvellePersonne));
  }

  @Override
  public PersonneDto editer(String id) {
    PersonneBusiness business = new PersonneBusiness(personneJpaRepository, personneMapper);
    return personneMapper.toPersonneDto(business.editer(id));
  }
}
