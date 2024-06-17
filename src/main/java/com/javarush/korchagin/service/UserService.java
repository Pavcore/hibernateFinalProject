package com.javarush.korchagin.service;

import com.javarush.korchagin.dbo.UserRepository;
import com.javarush.korchagin.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//todo удалить сервис после успешного тестирования бд

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public User get(Long id) {
        if (userRepository.get(id).isPresent()) {
            return userRepository.get(id).get();
        } else return null;
    }

    public List<User> getAll() {
        List<User> listUser = new ArrayList<>();
        List<Optional<User>> optionalList = userRepository.getAll();
        for (Optional<User> optionalUser : optionalList) {
            optionalUser.ifPresent(listUser::add);
        }
        return listUser;
    }

    public User update(Long id, User user) {
        return userRepository.update(id, user).get();
    }

    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}