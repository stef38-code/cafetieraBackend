package org.ilona.cafeteria.application.port.out.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "personne")
public class PersonneJpaEntity  {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "numero")
    private String numero;

    @OneToMany(mappedBy = "fk_personne")
    private List<TicketJpaEntity> tickets = new ArrayList<>();
}
