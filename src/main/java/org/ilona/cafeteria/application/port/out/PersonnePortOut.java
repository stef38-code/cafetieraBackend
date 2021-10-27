package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.business.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonnePortOut {
  Personne enregistrer(Personne personne);

  List<Personne> lister();

  void supprimer(String id);

  Personne modifier(Personne anciennePersonne, Personne nouvellePersonne);

  Personne editer(String id);

  void supprimer(Personne personne);

  Optional<Personne> rechercherParIdentifiant(String id);
}
