package org.ilona.cafeteria.adapter.in.web.entities;

import org.apache.commons.collections4.CollectionUtils;
import org.ilona.cafeteria.adapter.in.web.TicketControler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class TicketResource {

  private static void addLinks(TicketDto obj, String id) {
    if (Boolean.FALSE.equals(obj.hasLinks())) {
      Link link =
          WebMvcLinkBuilder.linkTo(methodOn(TicketControler.class).get(id))
              .withSelfRel()
              .withType("GET");
      obj.add(link);
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(TicketControler.class).supprimer(id))
              .withRel("supprimer")
              .withType("DELETE"));
      obj.add(
          WebMvcLinkBuilder.linkTo(methodOn(TicketControler.class).lister())
              .withRel("tickets")
              .withType("GET"));
    }
  }

  public static void addLinkByRef(TicketDto ticketDto) {
    addLinks(ticketDto, ticketDto.getId());
  }

  public static void addLinkByRef(List<TicketDto> tickets) {
    if (CollectionUtils.isNotEmpty(tickets)) {
      tickets.forEach(element -> addLinkByRef(element));
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
