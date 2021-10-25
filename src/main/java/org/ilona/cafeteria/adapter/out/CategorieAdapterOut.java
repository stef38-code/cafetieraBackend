package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.CategorieDto;
import org.ilona.cafeteria.application.port.out.CategoriePortOut;
import org.ilona.cafeteria.application.port.out.jpa.mapper.CategorieJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.CategorieJpaRepository;
import org.ilona.cafeteria.domaine.business.CategorieBusiness;
import org.ilona.cafeteria.domaine.entities.Categorie;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CategorieAdapterOut implements CategoriePortOut {
  private final CategorieJpaRepository categorieJpaRepository;
  private final CategorieJpaEntityMapper categorieMapper;

  @Override
  public CategorieDto enregistrer(CategorieDto categorieDto) {
    CategorieBusiness business = new CategorieBusiness(categorieJpaRepository, categorieMapper);
    Categorie categorie = categorieMapper.toCategorie(categorieDto);
    categorie = business.enregistrer(categorie);
    return categorieMapper.toCategorieDto(categorie);
  }

  @Override
  @Transactional
  public List<CategorieDto> lister() {
    CategorieBusiness business = new CategorieBusiness(categorieJpaRepository, categorieMapper);
    return categorieMapper.withBusinesstoCollectionDeCategorieDto(business.lister());
  }

  @Override
  public void supprimer(String id) {
    CategorieBusiness business = new CategorieBusiness(categorieJpaRepository, categorieMapper);
    Categorie categorie = business.editer(id);
    business.supprimer(categorie);
  }

  @Override
  public CategorieDto modifier(
      CategorieDto ancienneCategorieDto, CategorieDto nouvelleCategorieDto) {
    CategorieBusiness business = new CategorieBusiness(categorieJpaRepository, categorieMapper);
    Categorie ancienneCategorie = categorieMapper.toCategorie(ancienneCategorieDto);
    Categorie nouvelleCategorie = categorieMapper.toCategorie(nouvelleCategorieDto);
    return categorieMapper.toCategorieDto(business.modifier(ancienneCategorie, nouvelleCategorie));
  }

  @Override
  public CategorieDto editer(String id) {
    CategorieBusiness business = new CategorieBusiness(categorieJpaRepository, categorieMapper);
    return categorieMapper.toCategorieDto(business.editer(id));
  }
}
