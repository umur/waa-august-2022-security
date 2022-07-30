package com.springsecurity.service;

import java.util.Collection;

public interface BasicServiceInterface<T, ID> {
    Collection<T> getAll();
    T get(ID id);
    T save(T object);
    void delete(ID id);
}
