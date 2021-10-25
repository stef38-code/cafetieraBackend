package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDto extends RepresentationModel<CategorieDto> {
  private String id;
  private String nom;
  private String libelle;
}
