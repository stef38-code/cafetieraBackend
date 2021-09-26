package org.ilona.cafeteria.application.port.out.jpa.entities;

import lombok.Getter;

public enum Montant {
    TRENTE(30),VINGT(20);
    @Getter
    private int valeur;

    Montant(int valeur) {
        this.valeur = valeur;
    }
}
