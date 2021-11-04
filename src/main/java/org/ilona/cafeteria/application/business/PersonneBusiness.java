package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Personne;

import java.util.List;

public interface PersonneBusiness {
  List<Personne> lister();

  Personne enregistrer(Personne personne);

  void supprimer(Personne personne);

  void supprimer(String id);

  Personne modifier(Personne anciennePersonne, Personne nouvellePersonne);

  Personne editer(String id);
}
