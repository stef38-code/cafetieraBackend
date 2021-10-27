package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.repository.CategorieJpaRepository;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.mapper.CategorieJpaEntityMapper;
import org.ilona.cafeteria.application.mapper.CategorieMapper;
import org.ilona.cafeteria.application.port.out.CategoriePortOut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CategorieAdapterOut implements CategoriePortOut {
  private final CategorieJpaRepository repository;
  private final CategorieJpaEntityMapper mapperEntities;
  private final CategorieMapper mapperBusiness;

  @Override
  public Categorie enregistrer(Categorie categorie) {
    CategorieJpaEntity categorieJpaEntity = mapperEntities.to(categorie);
    CategorieJpaEntity resultat = repository.save(categorieJpaEntity);
    return mapperBusiness.to(resultat);
  }

  @Override
  public List<Categorie> lister() {
    List<CategorieJpaEntity> all = repository.findAll();
    return mapperBusiness.toCollection(all);
  }

  @Override
  public void supprimer(Categorie categorie) {
    CategorieJpaEntity categorieJpaEntity = mapperEntities.to(categorie);
    repository.delete(categorieJpaEntity);
  }

  @Override
  public Categorie modifier(Categorie ancienneCategorie, Categorie nouvelleCategorie) {
    nouvelleCategorie.setId(ancienneCategorie.getId());
    CategorieJpaEntity categorieJpaEntity = mapperEntities.to(nouvelleCategorie);
    CategorieJpaEntity resultat = repository.save(categorieJpaEntity);
    return mapperBusiness.to(resultat);
  }

  @Override
  public Categorie editer(String id) {
    CategorieJpaEntity resultat = repository.findById(id).orElse(null);
    return mapperBusiness.to(resultat);
  }

  @Override
  public Categorie rechercherParNom(String nom) {
    CategorieJpaEntity resultat = repository.findByNom(nom);
    return mapperBusiness.to(resultat);
  }

  @Override
  public Optional<Categorie> rechercherParIdentifiant(String id) {
    Optional<CategorieJpaEntity> resultat = repository.findById(id);
    if (resultat.isPresent()) return Optional.of(mapperBusiness.to(resultat.get()));

    return Optional.empty();
  }
}
