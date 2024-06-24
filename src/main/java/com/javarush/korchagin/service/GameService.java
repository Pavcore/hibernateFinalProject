package com.javarush.korchagin.service;

import com.javarush.korchagin.entity.Character;
import com.javarush.korchagin.entity.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;
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

    public List<Character> getAllUserCharacters(HttpSession session) {
        UserService userService = new UserService();
        String login = (String) session.getAttribute("login");
        User user = userService.findUserByLogin(login);
        return user.getCharacters();
    }
}
