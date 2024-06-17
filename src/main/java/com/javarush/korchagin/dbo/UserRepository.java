package com.javarush.korchagin.dbo;

import com.javarush.korchagin.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class UserRepository implements Repository<User, Long> {
    private final AtomicLong userCount = new AtomicLong();
    private final Map<Long, Optional<User>> userMap = new HashMap<>();

    @Override
    public void create(User user) {
        Optional<User> optionalUser = Optional.ofNullable(user);
        userMap.put(userCount.getAndIncrement(), optionalUser);
    }

    @Override
    public Stream<User> find(User pattern) {
        if (userMap.containsValue(Optional.ofNullable(pattern))) {
            assert pattern != null;
            return userMap.get(pattern.getId()).stream();
        }
        return Stream.empty();
    }

    @Override
    public Optional<User> get(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<Optional<User>> getAll() {
        return userMap.values().stream().toList();
    }

    @Override
    public Optional<User> update(Long id, User user) {
        Optional<User> optionalUser = userMap.get(id);
        if (optionalUser.isPresent()) {
            optionalUser.get().setId(user.getId());
            optionalUser.get().setLogin(user.getLogin());
            optionalUser.get().setPassword(user.getPassword());
        }
        return optionalUser;
    }

    @Override
    public boolean delete(Long id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
            return true;
        }
        return false;
    }
}