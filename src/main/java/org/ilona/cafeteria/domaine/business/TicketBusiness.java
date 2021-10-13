package org.ilona.cafeteria.domaine.business;

import org.ilona.cafeteria.application.port.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.TicketJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.TicketRepository;
import org.ilona.cafeteria.domaine.entities.Ticket;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class TicketBusiness {
  private final TicketRepository repository;
  private final TicketJpaEntityMapper mapper;

  public TicketBusiness(TicketRepository repository, TicketJpaEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<Ticket> lister() {
    return mapper.toCollectionTicket(repository.findAll());
  }

  public Ticket enregistrer(Ticket Ticket) {
    return mapper.toTicket(repository.save(mapper.toTicketJpaEntity(Ticket)));
  }

  @Transactional
  public void supprimer(Ticket Ticket) {
    // Affection de l'ID
    Ticket.setId(getId(Ticket));
    // suppression de la liaison entre la Ticket et les tickets
    Ticket.setPersonne(null);
    // mise à jour de la Ticket
    Ticket = enregistrer(Ticket);
    // suppression de la Ticket
    repository.delete(mapper.toTicketJpaEntity(Ticket));
  }

  public Ticket modifier(Ticket ancienneTicket, Ticket nouvelleTicket) {
    // Affection de l'ID
    nouvelleTicket.setId(getId(ancienneTicket));
    return mapper.toTicket(repository.save(mapper.toTicketJpaEntity(nouvelleTicket)));
  }

  /**
   * Recherche l'id depuis une Ticket
   *
   * @param Ticket la Ticket
   * @return la clef
   */
  private String getId(Ticket Ticket) {
    // recherche de la Ticket
    Ticket TicketInDb =
        mapper.toTicket(
            repository.findByNumeroAndMontant(
                Ticket.getNumero(), Ticket.getMontant()));

    return TicketInDb.getId();
  }

  public Ticket editer(String id) {

    Optional<TicketJpaEntity> byId = repository.findById(id);

    return mapper.toTicket(byId.orElse(null));
  }
}
