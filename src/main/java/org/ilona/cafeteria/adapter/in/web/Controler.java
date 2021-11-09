package org.ilona.cafeteria.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collection;

public abstract class Controler<O, C> {
    public abstract ResponseEntity<O> enregistrer(@RequestBody @Valid O personneDto);

    public abstract ResponseEntity<Collection<O>> lister();

    public abstract ResponseEntity<O> editer(@PathVariable String id);

    public abstract ResponseEntity<Void> supprimer(@PathVariable String id);

    public abstract ResponseEntity<Void> modifier(@RequestBody C entityController);
}
