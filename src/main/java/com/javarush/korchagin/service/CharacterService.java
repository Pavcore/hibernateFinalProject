package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.entity.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void create(Character character) {
        characterRepository.create(character);
    }

    public Character get(Long id) {
        return characterRepository.get(id).get();
    }

    public List<Character> getAll() {
        List<Character> characterList = new ArrayList<>();
        for (Optional<Character> optionalCharacter : characterRepository.getAll()) {
            characterList.add(optionalCharacter.get());
        }
        return characterList;
    }
}
