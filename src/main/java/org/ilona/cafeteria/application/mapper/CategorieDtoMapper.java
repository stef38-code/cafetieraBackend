package org.ilona.cafeteria.application.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieDto;
import org.ilona.cafeteria.adapter.in.web.entities.CategorieResource;
import org.ilona.cafeteria.adapter.in.web.entities.PersonneResource;
import org.ilona.cafeteria.adapter.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.application.business.entities.Categorie;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class CategorieDtoMapper {
  public abstract Categorie to(CategorieDto categorieDto);

  public abstract Categorie to(CategorieJpaEntity categorieJpaEntity);

  public abstract List<Categorie> toCollection(List<CategorieJpaEntity> categorieJpaEntities);

  public abstract CategorieDto to(Categorie categorie);

  @AfterMapping
  protected void addLinkByRef(@MappingTarget CategorieDto target) {
    if (Objects.nonNull(target)) {
      CategorieResource.addLinkByRef(target);
      if (CollectionUtils.isNotEmpty(target.getPersonnes())) {
        PersonneResource.addLinkByRef(target.getPersonnes());
      }
    }
  }

  public abstract List<CategorieDto> to(List<Categorie> categorieDtoList);
}
