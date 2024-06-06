package com.javarush.korchagin.dbo;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public interface Repository<T, ID> {
    public void create(T t);
    public Stream<T> find(T pattern);
    public Optional<T> get(ID id);
    public List<Optional<T>> getAll();
    public Optional<T> update(ID id, T t);
    public boolean delete(ID id);
}
