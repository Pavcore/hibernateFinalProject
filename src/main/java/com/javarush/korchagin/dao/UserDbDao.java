package com.javarush.korchagin.dao;

import com.javarush.korchagin.dbo.Repository;
import com.javarush.korchagin.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//todo доделать методы для работы с бд

public class UserDbDao implements Repository<User, Long> {

    @Override
    public void create(User user) {

    }

    @Override
    public Stream<User> find(User pattern) {
        return Stream.empty();
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Optional<User>> getAll() {
        return List.of();
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
