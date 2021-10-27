package org.ilona.cafeteria.adapter.out.jpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(
    name = "categorie",
    indexes = {@Index(name = "uniqueCategorie", columnList = "nom", unique = true)})
public class CategorieJpaEntity {
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "nom", nullable = true)
  @NotBlank(message = "Le nom est obligatoire")
  private String nom;

  @Column(name = "libelle")
  private String libelle;

  @JsonManagedReference
  @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
  private List<PersonneJpaEntity> personnes = new ArrayList<>();
}
