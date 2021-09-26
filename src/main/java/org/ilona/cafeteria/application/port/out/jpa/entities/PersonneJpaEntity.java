package org.ilona.cafeteria.application.port.out.jpa.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "personne",
indexes = {
        @Index(name = "uniquePersonne", columnList = "nom, prenom,numero", unique = true)
})
public class PersonneJpaEntity  {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @Column(name = "nom")
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;


    @Column(name = "prenom")
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;

    @Column(name = "numero")
    @NotBlank(message = "Le numero est obligatoire")
    private String numero;

    @OneToMany(mappedBy = "fk_personne",fetch=FetchType.EAGER)
    private List<TicketJpaEntity> tickets = new ArrayList<>();
}
