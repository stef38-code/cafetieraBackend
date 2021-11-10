package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Personne;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.TicketPortOut;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class TicketBusinessImpl implements TicketBusiness {
  private final TicketPortOut portOut;
  private final PersonnePortOut portOutPersonne;

  public TicketBusinessImpl(TicketPortOut portOut, PersonnePortOut portOutPersonne) {
    this.portOut = portOut;
    this.portOutPersonne = portOutPersonne;
  }

  @Override
  public List<Ticket> lister() {
    return portOut.lister();
  }

  @Override
  public Ticket enregistrer(Ticket ticket) {
    return portOut.enregistrer(ticket);
  }

  @Override
  @Transactional
  public void supprimer(Ticket ticket) {
    /*    // Affection de l'ID
    Ticket.setId(getId(Ticket));
    // suppression de la liaison entre la Ticket et les tickets
    Ticket.setPersonne(null);
    // mise à jour de la Ticket
    Ticket = enregistrer(Ticket);
    // suppression de la Ticket
    portOut.delete(mapper.toTicketJpaEntity(Ticket));*/
    portOut.supprimer(ticket);
  }

  @Override
  public Ticket modifier(Ticket ancienneTicket, Ticket nouveauTicket) {
    // Affection de l'ID
    nouveauTicket.setId(getId(ancienneTicket));
    return portOut.enregistrer(nouveauTicket);
  }

  @Override
  public String getId(Ticket ticket) {
    return ticket.getId();
  }

  /*  */
  /**
   * Recherche l'id depuis une Ticket
   *
   * @param Ticket la Ticket
   * @return la clef
   */
  /*
  @Override
  public String getId(Ticket ticket) {
    Categorie ticket = portOut.rechercherParId(ticket.getId());
    return portOut.getId();
  }*/
  @Override
  public Ticket editer(String id) {
    Optional<Ticket> byId = portOut.rechercherParIdentifiant(id);
    return byId.orElse(null);
  }

  @Override
  public List<Ticket> nonAffectes() {
    return portOut.rechercheDesTicketsNonAffectes();
  }

  public void affecter(String id, String idPersonne) {
    Personne personne = portOutPersonne.editer(idPersonne);
    Ticket ticket = portOut.editer(id);
    ticket.setPersonne(personne);
    portOut.enregistrer(ticket);
  }

  @Override
  public List<Ticket> personne(String id) {
    return portOut.rechercheDesTicketsUnePersonne(id);
  }
}
