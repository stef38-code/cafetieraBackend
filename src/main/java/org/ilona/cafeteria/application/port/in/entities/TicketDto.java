package org.ilona.cafeteria.application.port.in.entities;

import lombok.*;
import org.ilona.cafeteria.application.port.out.jpa.entities.Montant;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    @NotNull(message="Le numéro du ticket est obligatoire")
    private String numero;
    @NotNull(message="Le montant du ticket est obligaoire")
    private Integer montant;
}
