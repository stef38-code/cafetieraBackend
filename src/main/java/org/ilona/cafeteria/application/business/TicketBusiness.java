package org.ilona.cafeteria.application.business;

import org.ilona.cafeteria.application.business.entities.Ticket;

import javax.transaction.Transactional;
import java.util.List;

public interface TicketBusiness {
  List<Ticket> lister();

  Ticket enregistrer(Ticket ticket);

  @Transactional
  void supprimer(Ticket ticket);

  Ticket modifier(Ticket ancienneTicket, Ticket nouvelleTicket);

  String getId(Ticket ticket);

  Ticket editer(String id);

  List<Ticket> nonAffectes();

  void affecter(String id, String idPersonne);
}
