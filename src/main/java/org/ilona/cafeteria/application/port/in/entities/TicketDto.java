package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto extends RepresentationModel<TicketDto> {
    private String id;
    @NotNull(message="Le numéro du ticket est obligatoire")
    private String numero;
    @NotNull(message="Le montant du ticket est obligaoire")
    private Integer montant;
}
