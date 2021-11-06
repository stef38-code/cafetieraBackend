package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ilona.cafeteria.adapter.in.web.entities.TicketDto;
import org.ilona.cafeteria.application.business.TicketBusiness;
import org.ilona.cafeteria.application.business.TicketBusinessImpl;
import org.ilona.cafeteria.application.business.entities.Ticket;
import org.ilona.cafeteria.application.mapper.TicketDtoMapper;
import org.ilona.cafeteria.application.mapper.TicketMapper;
import org.ilona.cafeteria.application.port.in.TicketPortIn;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TicketService implements TicketPortIn {
    private final TicketPortOut portOut;
    private final PersonnePortOut portOutPersonne;
    private final TicketMapper mapper;
    private final TicketDtoMapper mapperDto;

    @Override
    public TicketDto enregistrer(TicketDto ticketDto) {
        Ticket ticket = mapper.to(ticketDto); // vient du portIn
        // traitement Bissness  avec portOut
        TicketBusiness business = new TicketBusinessImpl(portOut, portOutPersonne);
        ticket = business.enregistrer(ticket);
        // retour vers portIn
        return mapperDto.to(ticket);
    }

    @Override
    public List<TicketDto> lister() {
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        List<Ticket> ticketList = business.lister();
        return mapperDto.toCollection(ticketList);
    }

    @Override
    public TicketDto editer(String id) {
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        Ticket ticket = business.editer(id);
        return mapperDto.to(ticket);
    }

    @Override
    public void supprimer(String id) {
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        Ticket categorie = business.editer(id);
        business.supprimer(categorie);
    }

    @Override
    public void liberer(String id) {
        log.warn("//Todo a faire");
    }

    @Override
    public void modifier(TicketDto ancienTicket, TicketDto nouveauTicket) {
        Ticket ancienneTicket = mapper.to(ancienTicket);
        Ticket nouvelleTicket = mapper.to(nouveauTicket);
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        business.modifier(ancienneTicket, nouvelleTicket);
    }

    @Override
    public List<TicketDto> nonAffectes() {
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        List<Ticket> ticketList = business.nonAffectes();
        return mapperDto.toCollection(ticketList);
    }

    @Override
    public void affecter(String id, String idPersonne) {
        TicketBusinessImpl business = new TicketBusinessImpl(portOut, portOutPersonne);
        business.affecter(id, idPersonne);
    }
}
