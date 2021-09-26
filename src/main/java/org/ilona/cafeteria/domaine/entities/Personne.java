package org.ilona.cafeteria.domaine.entities;


import java.util.List;

/**
 * Classe representant l'éléve
 */
public class Personne {
    private String id;
    private String nom;
    private String prenom;
    private String numero;
    private List<Ticket> tickets;

    public Personne() {

    }

    public Personne(String id, String nom, String prenom,String numero, List<Ticket> tickets) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.tickets = tickets;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Personne{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", tickets=").append(tickets);
        sb.append('}');
        return sb.toString();
    }
}
