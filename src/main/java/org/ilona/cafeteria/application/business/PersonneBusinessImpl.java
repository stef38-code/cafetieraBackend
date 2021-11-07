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
    portOut.supprimer(personne);
  }

  @Override
  public void supprimer(String id) {
    portOut.supprimer(id);
  }

  public Personne modifier(Personne anciennePersonne, Personne nouvellePersonne) {
    return portOut.modifier(anciennePersonne, nouvellePersonne);
  }

  public Personne editer(String id) {

    Optional<Personne> byId = portOut.rechercherParIdentifiant(id);

    return byId.orElse(null);
  }
}
