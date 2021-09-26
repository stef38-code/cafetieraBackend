package org.ilona.cafeteria.domaine.entities;

import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Ticket {
    private String id;
    private String numero;
    private Integer montant;
    private Personne personne;

    public Ticket() {
    }

    public Ticket(String id, String numero, Integer montant, Personne personne) {
        this.id = id;
        this.numero = numero;
        this.montant = montant;
        this.personne = personne;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ticket{");
        sb.append("id='").append(id).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", montant=").append(montant);
        sb.append(", personne=").append(personne);
        sb.append('}');
        return sb.toString();
    }
}
