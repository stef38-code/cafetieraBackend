package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.ilona.cafeteria.application.port.out.jpa.mapper.TicketJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.TicketRepository;
import org.ilona.cafeteria.domaine.business.TicketBusiness;
import org.ilona.cafeteria.domaine.entities.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TicketAdapterOut implements TicketPortOut {
  private final TicketRepository ticketRepository;
  private final TicketJpaEntityMapper ticketMapper;

  @Override
  public TicketDto enregistrer(TicketDto ticketDto) {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    Ticket ticket = ticketMapper.toTicket(ticketDto);
    ticket = business.enregistrer(ticket);

    return ticketMapper.toTicketDto(ticket);
  }

  @Override
  public List<TicketDto> lister() {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    return ticketMapper.withBusinesstoCollectionDeTicketDto(business.lister());
  }

  @Override
  public TicketDto editer(String id) {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    return ticketMapper.toTicketDto(business.editer(id));
  }

  @Override
  public void supprimer(String id) {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    Ticket ticket = business.editer(id);
    business.supprimer(ticket);
  }

  @Override
  public void liberer(String id) {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    Ticket ticket = business.editer(id);
    ticket.setPersonne(null);
    business.enregistrer(ticket);
  }

  @Override
  public TicketDto modifier(TicketDto ancienTicketDto, TicketDto nouveauTicketDto) {
    TicketBusiness business = new TicketBusiness(ticketRepository, ticketMapper);
    Ticket ancienneTicket = ticketMapper.toTicket(ancienTicketDto);
    Ticket nouvelleTicket = ticketMapper.toTicket(nouveauTicketDto);
    return ticketMapper.toTicketDto(business.modifier(ancienneTicket, nouvelleTicket));
  }
}
