package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.jpa.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.PersonneRepository;
import org.ilona.cafeteria.domaine.business.PersonneBusiness;
import org.ilona.cafeteria.domaine.entities.Personne;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PersonneAdapterOut implements PersonnePortOut {
    private final PersonneRepository personneRepository;
    private final PersonneJpaEntityMapper personneMapper;

    @Override
    public PersonneDto enregistrer(PersonneDto personneDto){
        PersonneBusiness business = new PersonneBusiness(personneRepository,personneMapper);
        Personne personne = personneMapper.toPersonne(personneDto);
        personne = business.enregistrer(personne);
        return personneMapper.toPersonneDto(personne);
    }

    @Override
    @Transactional
    public List<PersonneDto> toutes() {
        PersonneBusiness business = new PersonneBusiness(personneRepository,personneMapper);
        return personneMapper.withBusinesstoCollectionDePersonneDto(business.toutes());
    }

    @Override
    public void supprimer(PersonneDto personneDto) {
        PersonneBusiness business = new PersonneBusiness(personneRepository,personneMapper);
        Personne personne = personneMapper.toPersonne(personneDto);
        business.supprimer(personne);
    }

    @Override
    public PersonneDto miseAjour(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto) {
        PersonneBusiness business = new PersonneBusiness(personneRepository,personneMapper);
        Personne anciennePersonne= personneMapper.toPersonne(anciennePersonneDto);
        Personne nouvellePersonne= personneMapper.toPersonne(nouvellePersonneDto);
        return personneMapper.toPersonneDto(business.miseAjour(anciennePersonne,nouvellePersonne));
    }

}
