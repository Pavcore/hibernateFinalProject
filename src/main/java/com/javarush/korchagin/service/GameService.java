package com.javarush.korchagin.service;

import com.javarush.korchagin.config.SessionCreator;
import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.dbo.UserRepository;
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
        CharacterRepository characterRepository = new CharacterRepository(new SessionCreator());
        UserRepository userRepository = new UserRepository(new SessionCreator());
        String login = (String) session.getAttribute("login");
        User user = userRepository
                .find(User.builder()
                        .login(login)
                        .build())
                .findFirst()
                .get();
        return characterRepository.getAllCurrentUserCharacters(user.getId());
    }
}
