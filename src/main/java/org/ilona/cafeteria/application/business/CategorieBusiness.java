package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Categorie;

import java.util.List;

public interface CategorieBusiness {
  List<Categorie> lister();

  Categorie enregistrer(Categorie categorie);

  void supprimer(Categorie categorie);

  Categorie modifier(Categorie ancienneCategorie, Categorie nouvelleCategorie);

  String getId(Categorie categorie);

  Categorie editer(String id);

  Categorie supprimer(String id);
}
