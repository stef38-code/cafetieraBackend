package org.ilona.cafeteria.application.port.out.jpa.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "ticket"
/*        ,
        uniqueConstraints ={
        @UniqueConstraint(name = "UniqueNumero", columnNames = { "numero" })}*/
)
public class TicketJpaEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "montant")
    private Integer montant;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_personne")
    private PersonneJpaEntity fk_personne;
}
