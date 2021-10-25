package org.ilona.cafeteria.domaine.business;

import org.ilona.cafeteria.application.port.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.CategorieJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.CategorieJpaRepository;
import org.ilona.cafeteria.domaine.entities.Categorie;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class CategorieBusiness {
  private final CategorieJpaRepository repository;
  private final CategorieJpaEntityMapper mapper;

  public CategorieBusiness(CategorieJpaRepository repository, CategorieJpaEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<Categorie> lister() {
    return mapper.toCollectionCategorie(repository.findAll());
  }

  public Categorie enregistrer(Categorie categorie) {
    return mapper.toCategorie(repository.save(mapper.toCategorieJpaEntity(categorie)));
  }

  @Transactional
  public void supprimer(Categorie categorie) {
    // Affection de l'ID
    categorie.setId(getId(categorie));
    repository.delete(mapper.toCategorieJpaEntity(categorie));
  }

  public Categorie modifier(Categorie ancienneCategorie, Categorie nouvelleCategorie) {
    // Affection de l'ID
    nouvelleCategorie.setId(getId(ancienneCategorie));
    return mapper.toCategorie(repository.save(mapper.toCategorieJpaEntity(nouvelleCategorie)));
  }

  /**
   * Recherche l'id depuis une categorie
   *
   * @param categorie la categorie
   * @return la clef
   */
  private String getId(Categorie categorie) {
    // recherche de la categorie
    Categorie CategorieInDb = mapper.toCategorie(repository.findByNom(categorie.getNom()));

    return CategorieInDb.getId();
  }

  public Categorie editer(String id) {

    Optional<CategorieJpaEntity> byId = repository.findById(id);

    return mapper.toCategorie(byId.orElse(null));
  }
}
