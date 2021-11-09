package org.ilona.cafeteria.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public abstract class ControlerTicket<O, C> extends Controler<O, C> {
    public abstract ResponseEntity<Collection<O>> nonAffectes();

    public abstract ResponseEntity<Void> affecter(@PathVariable String id, @PathVariable String idPersonne);

    public abstract ResponseEntity<Void> liberer(@PathVariable final String id);
}
