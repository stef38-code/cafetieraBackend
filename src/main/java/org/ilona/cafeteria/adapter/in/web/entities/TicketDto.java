package org.ilona.cafeteria.adapter.in.web.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto extends RepresentationModel<TicketDto> {
  private String id;

  @NotNull(message = "Le numéro du ticket est obligatoire")
  private String numero;

  @NotNull(message = "Le montant du ticket est obligaoire")
  private Integer montant;

  private PersonneDto personne;
}
