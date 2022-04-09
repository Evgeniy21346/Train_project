package vsu.kolesnikov.service;

import java.util.Collection;
import java.util.Optional;

public interface IService<T> {
    public void add(T obj);

    public void remove(String... args);

    public void update(T obj);

    public T find(String... args);

    public T findBy(String... args);

    public Collection<T> get();
}
