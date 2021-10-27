package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.repository.PersonneJpaRepository;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.mapper.PersonneMapper;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonneAdapterOut implements PersonnePortOut {
  private final PersonneJpaRepository repository;
  private final PersonneJpaEntityMapper mapperEntities;
  private final PersonneMapper mapperBusiness;

  @Override
  public Personne enregistrer(Personne personne) {
    PersonneJpaEntity personneJpaEntity = mapperEntities.to(personne);
    PersonneJpaEntity resultat = repository.save(personneJpaEntity);
    return mapperBusiness.to(resultat);
  }

  @Override
  @Transactional
  public List<Personne> lister() {
    List<PersonneJpaEntity> all = repository.findAll();
    return mapperBusiness.toCollection(all);
  }

  @Override
  public void supprimer(String id) {
    PersonneJpaEntity resultat = repository.findById(id).orElse(null);
    repository.delete(resultat);
  }

  @Override
  public void supprimer(Personne personne) {
    PersonneJpaEntity categorieJpaEntity = mapperEntities.to(personne);
    repository.delete(categorieJpaEntity);
  }

  @Override
  public Optional<Personne> rechercherParIdentifiant(String id) {
    return Optional.empty();
  }

  @Override
  public Personne modifier(Personne anciennePersonne, Personne nouvellePersonne) {
    nouvellePersonne.setId(anciennePersonne.getId());
    PersonneJpaEntity personneJpaEntity = mapperEntities.to(nouvellePersonne);
    PersonneJpaEntity resultat = repository.save(personneJpaEntity);
    return mapperBusiness.to(resultat);
  }

  @Override
  public Personne editer(String id) {
    PersonneJpaEntity resultat = repository.findById(id).orElse(null);
    return mapperBusiness.to(resultat);
  }
}
