package org.ilona.cafeteria.application.port.out.jpa.mapper;

import org.ilona.cafeteria.application.port.in.entities.CategorieDto;
import org.ilona.cafeteria.application.port.out.jpa.entities.CategorieJpaEntity;
import org.ilona.cafeteria.domaine.entities.Categorie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {PersonneJpaEntityMapper.class, TicketJpaEntityMapper.class, TicketMapperHelper.class})
public interface CategorieJpaEntityMapper {
  Categorie toCategorie(CategorieDto categorieDto);

  Categorie toCategorie(CategorieJpaEntity categorieJpaEntity);

  List<Categorie> toCollectionCategorie(List<CategorieJpaEntity> categorieJpaEntities);

  CategorieJpaEntity toCategorieJpaEntity(Categorie categorie);

  CategorieJpaEntity toCategorieJpaEntity(CategorieDto categorieDto);

  CategorieDto toCategorieDto(Categorie categorie);

  CategorieDto toCategorieDto(CategorieJpaEntity categorieJpaEntity);

  List<CategorieDto> withBusinesstoCollectionDeCategorieDto(List<Categorie> categories);

  List<CategorieDto> withJpaToCollectionDeCategorieDto(
      List<CategorieJpaEntity> categorieJpaEntities);
}
