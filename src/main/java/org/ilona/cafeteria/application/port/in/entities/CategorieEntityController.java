package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieEntityController {
  private CategorieDto nouvelleCategorie;

  @NotNull(message = "Cette variable ne peut pas être vide !!")
  private CategorieDto ancienneCategorie;
}
