package org.ilona.cafeteria.application.port.in.entities;

import org.ilona.cafeteria.adapter.in.web.PersonneControler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


public class PersonResource{// extends Hateoaspersonresource<PersonneDto> {
    private PersonneDto obj;
    public PersonResource(PersonneDto obj) {
        this.obj = obj;
    }
    public PersonneDto addLink(String id) {
        Link link = WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).get(id)).withSelfRel();
        obj.add(link);
        obj.add(WebMvcLinkBuilder.linkTo(methodOn(PersonneControler.class).getToutesLesPersonnes()).withRel("personnes"));
        return obj;
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
