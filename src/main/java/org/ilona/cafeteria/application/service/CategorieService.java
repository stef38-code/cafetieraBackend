package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.CategoriePortIn;
import org.ilona.cafeteria.application.port.in.entities.CategorieDto;
import org.ilona.cafeteria.application.port.in.entities.CategorieResource;
import org.ilona.cafeteria.application.port.out.CategoriePortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorieService implements CategoriePortIn {
  private final CategoriePortOut categoriePortOut;

  @Override
  public CategorieDto enregistrer(CategorieDto categorieDto) {
    return categoriePortOut.enregistrer(categorieDto);
  }

  @Override
  public List<CategorieDto> lister() {
    List<CategorieDto> categorieDtoList = categoriePortOut.lister();
    categorieDtoList.forEach(ticketDto -> CategorieResource.addLinkByRef(ticketDto));
    return categorieDtoList;
  }

  @Override
  public CategorieDto editer(String id) {
    CategorieDto categorieDto = categoriePortOut.editer(id);
    CategorieResource.addLinkByRef(categorieDto);
    return categorieDto;
  }

  @Override
  public void supprimer(String id) {
    categoriePortOut.supprimer(id);
  }

  @Override
  public void modifier(CategorieDto ancienneCategorie, CategorieDto nouvelleCategorie) {
    categoriePortOut.modifier(ancienneCategorie, nouvelleCategorie);
  }
}
