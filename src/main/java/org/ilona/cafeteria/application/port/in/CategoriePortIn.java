package org.ilona.cafeteria.application.port.in;

import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;

import java.util.List;

public interface CategoriePortIn {
  CategorieDto enregistrer(CategorieDto categorieDto);

  CategorieDto editer(String id);

  List<CategorieDto> lister();

  void supprimer(String id);

  void modifier(CategorieDto ancienneCategorie, CategorieDto nouvelleCategorie);
}
