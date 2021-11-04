package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.adapter.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.adapter.out.jpa.repository.TicketRepository;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.ilona.cafeteria.application.mapper.TicketJpaEntityMapper;
import org.ilona.cafeteria.application.mapper.TicketMapper;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TicketAdapterOut implements TicketPortOut {
    private final TicketRepository repository;
    private final TicketJpaEntityMapper mapperEntities;
    private final TicketMapper mapperBusiness;

    @Override
    public Ticket enregistrer(Ticket ticket) {
        TicketJpaEntity ticketJpaEntity = mapperEntities.to(ticket);
        TicketJpaEntity resultat = repository.save(ticketJpaEntity);
        return mapperBusiness.to(resultat);
    }

    @Override
    public List<Ticket> lister() {
        List<TicketJpaEntity> all = repository.findAll();
        return mapperBusiness.toCollection(all);
    }

    @Override
    public Ticket editer(String id) {
        TicketJpaEntity resultat = repository.findById(id).orElse(null);
        return mapperBusiness.to(resultat);
    }

    @Override
    public void supprimer(String id) {
        Ticket ticket = editer(id);
        supprimer(ticket);
    }

    @Override
    public void liberer(String id) {
        Ticket ticket = editer(id);
        ticket.setPersonne(null);
        enregistrer(ticket);
    }

    @Override
    public Ticket modifier(Ticket ancienTicket, Ticket nouveauTicket) {
        nouveauTicket.setId(ancienTicket.getId());
        TicketJpaEntity ticketJpaEntity = mapperEntities.to(nouveauTicket);
        TicketJpaEntity resultat = repository.save(ticketJpaEntity);
        return mapperBusiness.to(resultat);
    }

    @Override
    public void supprimer(Ticket ticket) {
        TicketJpaEntity ticketJpaEntity = mapperEntities.to(ticket);
        repository.delete(ticketJpaEntity);
    }

    @Override
    public Ticket rechercherParId(String id) {
        TicketJpaEntity resultat = repository.findById(id).orElse(null);
        return mapperBusiness.to(resultat);
    }

    @Override
    public Optional<Ticket> rechercherParIdentifiant(String id) {
        Optional<TicketJpaEntity> resultat = repository.findById(id);
        if (resultat.isPresent()) return Optional.of(mapperBusiness.to(resultat.get()));

        return Optional.empty();
    }

    @Override
    public List<Ticket> rechercheDesTicketsNonAffectes() {
        List<TicketJpaEntity> ticketJpaEntities = repository.findByPersonneIsNull();
        return mapperBusiness.toCollection(ticketJpaEntities);
    }
}
