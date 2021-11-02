package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Categorie;
import org.ilona.cafeteria.application.port.out.CategoriePortOut;

import java.util.List;
import java.util.Optional;

public class CategorieBusinessImpl implements CategorieBusiness {
  private final CategoriePortOut portOut;

  public CategorieBusinessImpl(CategoriePortOut portOut) {
    this.portOut = portOut;
  }

  @Override
  public List<Categorie> lister() {
    return portOut.lister();
  }

  @Override
  public Categorie enregistrer(Categorie categorie) {
    return portOut.enregistrer(categorie);
  }

  @Override
  public void supprimer(Categorie categorie) {
    //
    portOut.supprimer(categorie);
  }

  @Override
  public Categorie modifier(Categorie ancienneCategorie, Categorie nouvelleCategorie) {
    // Affection de l'ID
    nouvelleCategorie.setId(getId(ancienneCategorie));
    return portOut.enregistrer(nouvelleCategorie);
  }

  /**
   * Recherche l'id depuis une categorie
   *
   * @param categorie la categorie
   * @return la clef
   */
  @Override
  public String getId(Categorie categorie) {
    // recherche de la categorie
    Categorie CategorieInDb = portOut.rechercherParNom(categorie.getNom());
    return CategorieInDb.getId();
  }

  @Override
  public Categorie editer(String id) {
    Optional<Categorie> byId = portOut.rechercherParIdentifiant(id);
    return byId.orElse(null);
  }

  @Override
  public Categorie supprimer(String id) {
    Optional<Categorie> byId = portOut.rechercherParIdentifiant(id);

    return byId.orElse(null);
  }
}
