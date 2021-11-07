package org.ilona.cafeteria.application.port.out;

import org.ilona.cafeteria.application.business.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketPortOut {
  Ticket enregistrer(Ticket ticket);

  List<Ticket> lister();

  Ticket editer(String id);

  void supprimer(String id);

  void liberer(String id);

  Ticket modifier(Ticket ancienTicket, Ticket nouveauTicket);

  void supprimer(Ticket ticket);

  Ticket rechercherParId(String id);

  Optional<Ticket> rechercherParIdentifiant(String id);

  List<Ticket> rechercheDesTicketsNonAffectes();
}
