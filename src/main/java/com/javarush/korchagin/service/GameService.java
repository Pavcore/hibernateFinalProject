package com.javarush.korchagin.service;

import com.javarush.korchagin.config.SpringApplicationContext;
import com.javarush.korchagin.dbo.CharacterRepository;
import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.Character;
import com.javarush.korchagin.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@NoArgsConstructor
public class GameService {

    private final AtomicLong atomicLong = new AtomicLong();

    public long gameQuantity() {
        return atomicLong.get();
    }

    public void increaseGameAmount() {
        atomicLong.getAndIncrement();
    }

    public List<Character> getAllUserCharacters(HttpSession session) {
        CharacterRepository characterRepository = SpringApplicationContext.getInstance().getBean(CharacterRepository.class);
        UserRepository userRepository = SpringApplicationContext.getInstance().getBean(UserRepository.class);
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
