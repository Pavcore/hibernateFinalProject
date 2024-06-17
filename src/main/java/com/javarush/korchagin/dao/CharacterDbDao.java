package com.javarush.korchagin.dao;

import com.javarush.korchagin.dbo.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//todo доделать методы для работы с бд

public class CharacterDbDao implements Repository<Long, Character> {
    @Override
    public void create(Long aLong) {

    }

    @Override
    public Stream<Long> find(Long pattern) {
        return Stream.empty();
    }

    @Override
    public Optional<Long> get(Character character) {
        return Optional.empty();
    }

    @Override
    public List<Optional<Long>> getAll() {
        return List.of();
    }

    @Override
    public Optional<Long> update(Character character, Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Character character) {
        return false;
    }
}
