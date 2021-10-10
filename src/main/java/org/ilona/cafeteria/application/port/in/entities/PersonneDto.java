package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonneDto extends RepresentationModel<PersonneDto> {
    private String id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;
    @NotBlank(message = "Le identifiant de l'eleve est obligatoire")
    private String numero;
    private List<TicketDto> tickets = new ArrayList<>();
    private int nombreTicket;
}
