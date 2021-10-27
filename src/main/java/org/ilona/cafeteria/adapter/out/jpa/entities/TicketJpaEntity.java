package org.ilona.cafeteria.adapter.out.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"personne"})
@RequiredArgsConstructor
@Entity
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
    name = "ticket"
    /*        ,
    uniqueConstraints ={
    @UniqueConstraint(name = "UniqueNumero", columnNames = { "numero" })}*/
    )
public class TicketJpaEntity {
  private static final long serialVersionUID = 7720285113632455831L;

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "numero", nullable = true)
  private String numero;

  @Column(name = "montant", nullable = true)
  private Integer montant;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_personne")
  private PersonneJpaEntity personne;
}
