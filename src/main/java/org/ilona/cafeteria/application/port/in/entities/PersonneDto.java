package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonneDto {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;
    @NotBlank(message = "Le identifiant de l'eleve est obligatoire")
    private String numero;
    private List<TicketDto> tickets = new ArrayList<>();
    private int nombreTicket;
}
