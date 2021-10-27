package org.ilona.cafeteria.application.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieResource;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneDto;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneResource;
import org.ilona.cafeteria.adapter.in.web.entities.TicketResource;
import org.ilona.cafeteria.adapter.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.business.entities.Personne;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Objects;

@Mapper(
    componentModel = "spring",
    uses = {TicketMapperHelper.class})
public abstract class PersonneDtoMapper {
  abstract Personne toPersonne(PersonneDto personneDto);

  abstract Personne toPersonne(PersonneJpaEntity personneJpaEntity);

  public abstract List<PersonneDto> toCollection(List<Personne> personneList);

  public abstract PersonneDto to(Personne personne);

  @AfterMapping
  protected void addLinkByRef(@MappingTarget PersonneDto target) {
    if (Objects.nonNull(target)) {
      PersonneResource.addLinkByRef(target);
      if (CollectionUtils.isNotEmpty(target.getTickets())) {
        TicketResource.addLinkByRef(target.getTickets());
      }
      if (Objects.nonNull(target.getCategorie())) {
        CategorieResource.addLinkByRef(target.getCategorie());
      }
    }
  }
}
