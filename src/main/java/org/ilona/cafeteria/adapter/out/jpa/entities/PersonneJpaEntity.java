package org.ilona.cafeteria.adapter.out.jpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
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
@EqualsAndHashCode(exclude = "tickets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(
    name = "personne",
    indexes = {
      @Index(name = "uniquePersonne", columnList = "nom, prenom,idcategorie", unique = true)
    })
public class PersonneJpaEntity {
  private static final long serialVersionUID = -7086809764656937022L;

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "nom", nullable = false)
  @NotBlank(message = "Le nom est obligatoire")
  private String nom;

  @Column(name = "prenom", nullable = false)
  @NotBlank(message = "Le prenom est obligatoire")
  private String prenom;

  // @ToString.Exclude
  @JsonManagedReference
  @OneToMany(mappedBy = "personne", fetch = FetchType.EAGER)
  private List<TicketJpaEntity> tickets = new ArrayList<>();

  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idcategorie", nullable = true)
  private CategorieJpaEntity categorie;
}
