package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.repository.PersonneJpaRepository;
import org.ilona.cafeteria.adapter.out.jpa.repository.TicketRepository;
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
@Slf4j
public class PersonneAdapterOut implements PersonnePortOut {
  private final PersonneJpaRepository repository;
  private final TicketRepository repositoryRepository;
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
    Optional<Personne> personne = rechercherParIdentifiant(id);
    if (personne.isPresent()) {
      supprimer(personne.get());
    } else {
      log.info("//todo mettre une erreur!!");
    }
  }

  @Override
  public void supprimer(Personne personne) {
    PersonneJpaEntity personneJpaEntity = mapperEntities.to(personne);
    //Supprimer la liaison avec les tickets
    personneJpaEntity.getTickets().forEach(ticket -> {
      ticket.setPersonne(null);
      repositoryRepository.save(ticket);
    });
    repository.delete(personneJpaEntity);
  }

  @Override
  public Optional<Personne> rechercherParIdentifiant(String id) {
    PersonneJpaEntity resultat = repository.findById(id).orElse(null);
    Personne personne = mapperBusiness.to(resultat);
    return Optional.ofNullable(personne);
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
