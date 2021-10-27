package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.business.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategoriePortOut {
  Categorie enregistrer(Categorie categorie);

  List<Categorie> lister();

  Categorie modifier(Categorie ancienneCategorie, Categorie nouvelleCategorie);

  Categorie editer(String id);

  Categorie rechercherParNom(String nom);

  Optional<Categorie> rechercherParIdentifiant(String id);

  void supprimer(Categorie categorie);
}
