package com.javarush.korchagin.dbo;

import java.util.Collection;
import java.util.stream.Stream;

public interface Repository<T> {
    void create(T t);

    Stream<T> find(T pattern);

    T get(long id);

    Collection<T> getAll();

    void update(T t);

    void delete(T t);
}
