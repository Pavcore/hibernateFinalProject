package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public boolean login(String login, String password) {
        User user = User.builder().login(login).password(password).build();
        List<User> dbList = userRepository.find(user).toList();
        if (dbList.isEmpty()) {
            return false;
        }
        User dbUser = dbList.getFirst();
        return dbUser.getLogin().equals(login) && dbUser.getPassword().equals(password);
    }

    public boolean register(String login, String password) {
        User user = User.builder().login(login).password(password).build();
        List<User> dbList = userRepository.find(user).toList();
        if (dbList.isEmpty()) {
            userRepository.create(user);
            return true;
        }
        return false;
    }
}
