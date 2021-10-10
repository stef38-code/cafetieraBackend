package org.ilona.cafeteria.application.port.out.jpa.mapper;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.domaine.entities.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring",uses = {TicketJpaEntityMapper.class,TicketMapperHelper.class})
public interface  PersonneJpaEntityMapper {
    Personne toPersonne(PersonneDto personneDto);

    Personne toPersonne(PersonneJpaEntity personneJpaEntity);
    List<Personne> toCollectionPersonne(List<PersonneJpaEntity> PersonneJpaEntities);

    PersonneJpaEntity toPersonneJpaEntity(Personne personne);

    PersonneJpaEntity toPersonneJpaEntity(PersonneDto personneDto);

    @Mapping( target = "nombreTicket",source="tickets", qualifiedByName = "compteLesTickets")
    PersonneDto toPersonneDto(Personne personne);




    PersonneDto toPersonneDto(PersonneJpaEntity personneJpaEntity);
    List<PersonneDto> withBusinesstoCollectionDePersonneDto(List<Personne> Personne);
    List<PersonneDto> withJpaToCollectionDePersonneDto(List<PersonneJpaEntity> PersonneJpaEntities);

}
