package org.ilona.cafeteria.adapter.in.web.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDto extends RepresentationModel<PersonneDto> {
  private String id;

  @NotBlank(message = "Le nom est obligatoire")
  private String nom;

  @NotBlank(message = "Le prénom est obligatoire")
  private String prenom;

  private List<TicketDto> tickets = new ArrayList<>();
  private int nombreTicket;
  private CategorieDto categorie;
}
