package org.ilona.cafeteria.application.port.in.entities;

import lombok.Getter;

@Getter
public abstract class Hateoaspersonresource<T> {
  private T obj;

  public Hateoaspersonresource(T obj) {
    obj = obj;
  }

  public T addLink(String id) {
    return obj;
  }
}
