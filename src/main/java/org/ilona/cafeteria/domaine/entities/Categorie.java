package org.ilona.cafeteria.domaine.entities;

/** Classe representant l'éléve */
public class Categorie {
  private String id;
  private String nom;
  private String libelle;

  public Categorie() {}

  public Categorie(String id, String nom, String libelle) {
    this.id = id;
    this.nom = nom;
    this.libelle = libelle;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Categorie{");
    sb.append("id='").append(id).append('\'');
    sb.append(", nom='").append(nom).append('\'');
    sb.append(", libelle='").append(libelle).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
