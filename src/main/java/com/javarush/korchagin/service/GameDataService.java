package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.entity.Character;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class GameDataService {

    private static GameDataService gameData;
    @Getter
    private final CharacterService characterService = new CharacterService(new CharacterRepository());
    private final AtomicLong atomicLong = new AtomicLong();

    private GameDataService() {
    }

    public static GameDataService getInstance() {
        if (gameData == null) {
            gameData = new GameDataService();
        }
        return gameData;
    }

    public void create(Character character) {
        characterService.create(character);
    }

    public List<Character> getAll() {
        return characterService.getAll();
    }

    public long gameQuantity() {
        return atomicLong.get();
    }

    public void increaseGameAmount() {
        atomicLong.getAndIncrement();
    }
}
