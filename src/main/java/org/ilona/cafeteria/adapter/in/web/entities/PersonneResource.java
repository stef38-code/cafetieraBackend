package org.ilona.cafeteria.adapter.in.web.entities;

import org.apache.commons.collections4.CollectionUtils;
import org.ilona.cafeteria.adapter.in.web.PersonneControler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class PersonneResource {

  private static void addLinks(PersonneDto obj, String id) {
    if (Boolean.FALSE.equals(obj.hasLinks())) {
      Link link =
          WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).editer(id))
              .withSelfRel()
              .withType("GET");
      obj.add(link);
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).supprimer(id))
              .withRel("supprimer")
              .withType("DELETE"));
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).lister())
              .withRel("lister")
              .withType("GET"));
    }
  }

  public static void addLinkByRef(PersonneDto personneDto) {
    addLinks(personneDto, personneDto.getId());
  }

  public static void addLinkByRef(List<PersonneDto> personnes) {
    if (CollectionUtils.isNotEmpty(personnes)) {
      personnes.forEach(element -> addLinkByRef(element));
    }
  }
  /*    public PersonResource(PersonneDto personne) {

      this.personne = personne;
      final String id = personne.getId();

      //add(linkTo(methodOn(GymMembershipController.class).all(id)).withRel("memberships"));
      //add(linkTo(methodOn(PersonneControler.class).get(id)).withSelfRel());
  }*/
  /*  @Override
  public PersonneDto addLink(String id) {
    Link link = WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).get(id)).withSelfRel();
    getObj().add(link);
    return getObj();
  }*/
}
