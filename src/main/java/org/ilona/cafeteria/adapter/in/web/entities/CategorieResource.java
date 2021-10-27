package org.ilona.cafeteria.adapter.in.web.entities;

import org.ilona.cafeteria.adapter.in.web.CategorieControler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CategorieResource {

  private static void addLinks(CategorieDto obj, String id) {
    if (Boolean.FALSE.equals(obj.hasLinks())) {
      Link link =
          WebMvcLinkBuilder.linkTo(methodOn(CategorieControler.class).editer(id))
              .withSelfRel()
              .withType("GET");
      obj.add(link);
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(CategorieControler.class).supprimer(id))
              .withRel("supprimer")
              .withType("DELETE"));
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(CategorieControler.class).lister())
              .withRel("lister")
              .withType("GET"));
    }
  }

  public static void addLinkByRef(CategorieDto categorieDto) {
    addLinks(categorieDto, categorieDto.getId());
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
