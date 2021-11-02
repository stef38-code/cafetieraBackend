package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;
import org.ilona.cafeteria.application.business.CategorieBusiness;
import org.ilona.cafeteria.application.business.CategorieBusinessImpl;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.mapper.CategorieDtoMapper;
import org.ilona.cafeteria.application.mapper.CategorieMapper;
import org.ilona.cafeteria.application.port.in.CategoriePortIn;
import org.ilona.cafeteria.application.port.out.CategoriePortOut;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorieService implements CategoriePortIn {
  private final CategoriePortOut portOut;
  private final CategorieMapper mapper;
  private final CategorieDtoMapper mapperDto;
  private final PersonnePortOut personnePortOut;

  @Override
  public CategorieDto enregistrer(CategorieDto categorieDto) {
    Categorie categorie = mapper.to(categorieDto); // vient du portIn
    // traitement Bissness  avec portOut
    CategorieBusiness business = new CategorieBusinessImpl(portOut);
    categorie = business.enregistrer(categorie);
    // retour vers portIn
    return mapperDto.to(categorie);
  }

  @Override
  public List<CategorieDto> lister() {
    CategorieBusiness business = new CategorieBusinessImpl(portOut);
    List<Categorie> categorieDtoList = business.lister();
    /* categorieDtoList.forEach(ticketDto -> CategorieResource.addLinkByRef(ticketDto));*/
    return mapperDto.to(categorieDtoList);
  }

  @Override
  public CategorieDto editer(String id) {
    CategorieBusiness business = new CategorieBusinessImpl(portOut);
    Categorie categorie = business.editer(id);
    // CategorieResource.addLinkByRef(categorieDto);
    return mapperDto.to(categorie);
  }

  @Override
  public void supprimer(String id) {
    CategorieBusiness business = new CategorieBusinessImpl(portOut);
    Categorie categorie = business.supprimer(id);
    categorie
        .getPersonnes()
        .forEach(
            personne -> {
              // mise à jour de la categorie du personne
              personne.setCategorie(null);
              personnePortOut.enregistrer(personne);
            });
    // Suppression de la liaison avec les personnes dans la categorie
    categorie.setPersonnes(Collections.emptyList());
    business.supprimer(categorie);
  }

  @Override
  public void modifier(CategorieDto ancienneCategorieDto, CategorieDto nouvelleCategorieDto) {
    Categorie ancienneCategorie = mapper.to(ancienneCategorieDto);
    Categorie nouvelleCategorie = mapper.to(nouvelleCategorieDto);
    CategorieBusiness business = new CategorieBusinessImpl(portOut);
    business.modifier(ancienneCategorie, nouvelleCategorie);
  }
}
