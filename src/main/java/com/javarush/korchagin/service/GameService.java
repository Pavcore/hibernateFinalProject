package com.javarush.korchagin.service;

import java.util.concurrent.atomic.AtomicLong;

public class GameService {

    private static GameService gameData;
    private final AtomicLong atomicLong = new AtomicLong();

    private GameService() {
    }

    public static GameService getInstance() {
        if (gameData == null) {
            gameData = new GameService();
        }
        return gameData;
    }

    public long gameQuantity() {
        return atomicLong.get();
    }

    public void increaseGameAmount() {
        atomicLong.getAndIncrement();
    }
}
