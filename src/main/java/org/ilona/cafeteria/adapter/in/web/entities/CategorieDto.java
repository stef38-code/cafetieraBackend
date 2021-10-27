package org.ilona.cafeteria.adapter.in.web.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto extends RepresentationModel<CategorieDto> {
  private String id;
  private String nom;
  private String libelle;
  private List<PersonneDto> personnes;
}
