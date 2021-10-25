package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.port.in.entities.CategorieDto;

import java.util.List;

public interface CategoriePortOut {
  CategorieDto enregistrer(CategorieDto personneDto);

  List<CategorieDto> lister();

  void supprimer(String id);

  CategorieDto modifier(CategorieDto ancienneCategorieDto, CategorieDto nouvelleCategorieDto);

  CategorieDto editer(String id);
}
