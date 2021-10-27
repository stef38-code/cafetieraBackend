package org.ilona.cafeteria.adapter.out.jpa.entities;

import lombok.Getter;

public enum Montant {
  TRENTE(30),
  VINGT(20);
  @Getter private int valeur;

  Montant(int valeur) {
    this.valeur = valeur;
  }
}
