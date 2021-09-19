package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.TicketDto;
import org.ilona.cafeteria.application.port.out.TicketPortOut;
import org.ilona.cafeteria.application.port.out.jpa.entities.TicketJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.TicketJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.TicketRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TicketAdapterOut implements TicketPortOut {
    private final TicketRepository ticketRepository;
    private final TicketJpaEntityMapper ticketJpaEntityMapper;

    @Override
    public TicketDto ajouterUnTicket(TicketDto ticketDto){
        TicketJpaEntity ticketJpaEntity = ticketJpaEntityMapper.toTicketJpaEntity(ticketDto);
        ticketJpaEntity = ticketRepository.save(ticketJpaEntity);
        return ticketJpaEntityMapper.toTicketDto(ticketJpaEntity);
    }

    @Override
    public List<TicketDto> toutesLesTickets() {
        List<TicketJpaEntity> all = ticketRepository.findAll();
        return ticketJpaEntityMapper.toCollectionDeTicketDto(all);
    }

}
