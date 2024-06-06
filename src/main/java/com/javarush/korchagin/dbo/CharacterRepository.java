package com.javarush.korchagin.dbo;

import com.javarush.korchagin.entity.Character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class CharacterRepository implements Repository<Character, Long> {
    private final AtomicLong atomicLong = new AtomicLong();
    private final Map<Long, Optional<Character>> characterMap = new HashMap<>();

    public CharacterRepository() {
    }

    public void create(Character character) {
        Optional<Character> optionalCharacter = Optional.ofNullable(character);
        characterMap.put(atomicLong.getAndIncrement(), optionalCharacter);
    }

    @Override
    public Stream<Character> find(Character pattern) {
        return Stream.empty();
    }

    public Optional<Character> get(Long id) {
        return characterMap.get(id);
    }

    public List<Optional<Character>> getAll() {
        return characterMap.values().stream().toList();
    }

    //not usage
    @Override
    public Optional<Character> update(Long aLong, Character character) {
        return Optional.empty();
    }

    //not usage
    @Override
    public boolean delete(Long aLong) {
        return false;
    }
}
