package com.springsecurity.api.util;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface BasicControllerInterface<T, ID> {
    ResponseEntity<Collection<T>> getAll();
    ResponseEntity<T> get(ID id);
    ResponseEntity<T> save(T obj);
    ResponseEntity<?> delete(ID id);
}
