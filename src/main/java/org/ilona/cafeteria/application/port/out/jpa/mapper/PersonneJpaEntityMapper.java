package org.ilona.cafeteria.application.port.out.jpa.mapper;

import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.domaine.Personne;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface  PersonneJpaEntityMapper {
    Personne toPersonne(PersonneJpaEntity personneJpaEntity);
    PersonneJpaEntity toPersonneJpaEntity(Personne personne);
    PersonneJpaEntity toPersonneJpaEntity(PersonneDto personneDto);

    PersonneDto toPersonneDto(PersonneJpaEntity personneJpaEntity);
    List<PersonneDto> toCollectionDePersonneDto(List<PersonneJpaEntity> PersonneJpaEntities);
}
