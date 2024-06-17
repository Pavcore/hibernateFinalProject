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
        if (characterMap.containsValue(Optional.ofNullable(pattern))) {
            assert pattern != null;
            return characterMap.get(pattern.getId()).stream();
        }
        return Stream.empty();
    }

    public Optional<Character> get(Long id) {
        return characterMap.get(id);
    }

    public List<Optional<Character>> getAll() {
        return characterMap.values().stream().toList();
    }


    @Override
    public Optional<Character> update(Long id, Character character) {
        Optional<Character> optionalCharacter = characterMap.get(id);
        if (optionalCharacter.isPresent()) {
            optionalCharacter.get().setId(character.getId());
            optionalCharacter.get().setCharacterClass(character.getCharacterClass());
        }
        return optionalCharacter;
    }


    @Override
    public boolean delete(Long id) {
        if (characterMap.containsKey(id)) {
            characterMap.remove(id);
            return true;
        }
        return false;
    }
}
