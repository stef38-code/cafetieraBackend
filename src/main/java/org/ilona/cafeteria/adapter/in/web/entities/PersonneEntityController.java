package org.ilona.cafeteria.adapter.in.web.entities;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonneEntityController {
  private PersonneDto nouvellePersonne;

  @NotNull(message = "Cette variable ne peut pas être vide !!")
  private PersonneDto anciennePersonne;
}
