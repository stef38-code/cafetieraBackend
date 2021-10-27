package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class PersonneBusinessImpl implements PersonneBusiness {
  private final PersonnePortOut portOut;

  public PersonneBusinessImpl(PersonnePortOut portOut) {
    this.portOut = portOut;
  }

  public List<Personne> lister() {

    return portOut.lister();
  }

  public Personne enregistrer(Personne personne) {
    return portOut.enregistrer(personne);
  }

  @Transactional
  public void supprimer(Personne personne) {
    /*// Affection de l'ID
    personne.setId(getId(personne));
    // suppression de la liaison entre la personne et les tickets
    personne.setTickets(null);
    // mise à jour de la personne
    personne = enregistrer(personne);
    // suppression de la personne*/
    portOut.supprimer(personne);
  }

  public Personne modifier(Personne anciennePersonne, Personne nouvellePersonne) {
    return portOut.modifier(anciennePersonne, nouvellePersonne);
  }

  /**
   * Recherche l'id depuis une personne
   *
   * @param personne la personne
   * @return la clef
   */
  /*
  private String getId(Personne personne) {
    // recherche de la personne
    Personne personneInDb =
        mapper.toPersonne(
            portOut.findByNomAndPrenomAndCategorie(
                personne.getNom(), personne.getPrenom(), personne.getCategorie()));

    return personneInDb.getId();
  }*/

  public Personne editer(String id) {

    Optional<Personne> byId = portOut.rechercherParIdentifiant(id);

    return byId.orElse(null);
  }
}
