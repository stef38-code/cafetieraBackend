package org.ilona.cafeteria.domaine.business;

import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.PersonneRepository;
import org.ilona.cafeteria.domaine.entities.Personne;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class PersonneBusiness {
  private final PersonneRepository repository;
  private final PersonneJpaEntityMapper mapper;

  public PersonneBusiness(PersonneRepository repository, PersonneJpaEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<Personne> toutes() {
    return mapper.toCollectionPersonne(repository.findAll());
  }

  public Personne enregistrer(Personne personne) {
    return mapper.toPersonne(repository.save(mapper.toPersonneJpaEntity(personne)));
  }

  @Transactional
  public void supprimer(Personne personne) {
    // Affection de l'ID
    personne.setId(getId(personne));
    // suppression de la liaison entre la personne et les tickets
    personne.setTickets(null);
    // mise à jour de la personne
    personne = enregistrer(personne);
    // suppression de la personne
    repository.delete(mapper.toPersonneJpaEntity(personne));
  }

  public Personne miseAjour(Personne anciennePersonne, Personne nouvellePersonne) {
    // Affection de l'ID
    nouvellePersonne.setId(getId(anciennePersonne));
    return mapper.toPersonne(repository.save(mapper.toPersonneJpaEntity(nouvellePersonne)));
  }

  /**
   * Recherche l'id depuis une personne
   *
   * @param personne la personne
   * @return la clef
   */
  private String getId(Personne personne) {
    // recherche de la personne
    Personne personneInDb =
        mapper.toPersonne(
            repository.findByNomAndPrenomAndNumero(
                personne.getNom(), personne.getPrenom(), personne.getNumero()));

    return personneInDb.getId();
  }

  public Personne unePersonne(String id) {

    Optional<PersonneJpaEntity> byId = repository.findById(id);

    return mapper.toPersonne(byId.orElse(null));
  }
}
