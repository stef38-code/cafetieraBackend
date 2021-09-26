package org.ilona.cafeteria.domaine.business;

import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.PersonneRepository;
import org.ilona.cafeteria.domaine.entities.Personne;

import java.util.List;

public class PersonneBusiness {
    private final PersonneRepository repository;
    private final PersonneJpaEntityMapper mapper;

    public PersonneBusiness( PersonneRepository repository, PersonneJpaEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Personne> getToutesLesPersonnes() {
        return mapper.toCollectionPersonne(repository.findAll());
    }

    public Personne getAjouterUnePersonne(Personne personne) {
        return mapper.toPersonne(repository.save(
                mapper.toPersonneJpaEntity(personne)
        ));
    }

    /*public Personne ajouterUnePersonne(Personne personne){
       return mapper.toPersonne(
        personnePortOut.ajouterUnePersonne(mapper.toPersonneJpaEntity(personne));
    }*/
}
