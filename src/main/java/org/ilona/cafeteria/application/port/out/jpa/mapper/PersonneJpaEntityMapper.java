package org.ilona.cafeteria.application.port.out.jpa.mapper;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.domaine.entities.Personne;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",uses = {TicketJpaEntityMapper.class})
public interface  PersonneJpaEntityMapper {
    Personne toPersonne(PersonneJpaEntity personneJpaEntity);
    Personne toPersonne(PersonneDto personneDto);
    PersonneJpaEntity toPersonneJpaEntity(Personne personne);
    PersonneJpaEntity toPersonneJpaEntity(PersonneDto personneDto);

    PersonneDto toPersonneDto(PersonneJpaEntity personneJpaEntity);
    PersonneDto toPersonneDto(Personne personne);
    List<PersonneDto> withJpaToCollectionDePersonneDto(List<PersonneJpaEntity> PersonneJpaEntities);
    List<PersonneDto> withBusinesstoCollectionDePersonneDto(List<Personne> Personne);

    List<Personne> toCollectionPersonne(List<PersonneJpaEntity> PersonneJpaEntities);
}
